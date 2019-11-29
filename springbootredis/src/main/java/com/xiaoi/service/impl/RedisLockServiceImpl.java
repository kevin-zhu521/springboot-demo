package com.xiaoi.service.impl;

import com.xiaoi.service.RedisLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * redis锁
 *
 * @author kevin.zhu
 * @date 2019/11/29 18:09
 */
@Service
public class RedisLockServiceImpl implements RedisLockService {

    /**
     * 加锁标志
     */
    public static final String LOCKED = "TRUE";
    /**
     * 毫秒与毫微秒的换算单位 1毫秒 = 1000000毫微秒
     */
    public static final long MILLI_NANO_CONVERSION = 1000 * 1000L;
    /**
     * 默认超时时间（毫秒）
     */
    public static final long DEFAULT_TIME_OUT = 1000;
    public static final Random RANDOM = new Random();
    /**
     * 锁的超时时间（秒），过期删除
     */
    public static final int EXPIRE = 3 * 60;

    private String key;

    private boolean locked = false;

    @Autowired
    private StringRedisTemplate redisTemplate;

    public boolean lock(long timeout) {
        long nano = System.nanoTime();
        timeout *= MILLI_NANO_CONVERSION;
        if (addLock(timeout, nano, EXPIRE)) {
            this.locked = true;
            return locked;
        }
        return locked;
    }

    public boolean lock(long timeout, int expire) {
        long nano = System.nanoTime();
        timeout *= MILLI_NANO_CONVERSION;
        if (addLock(timeout, nano, expire)) {
            this.locked = true;
            return locked;

        }
        return locked;
    }

    /**
     * 默认加锁
     *
     * @return
     */
    public boolean lock() {
        return lock(DEFAULT_TIME_OUT);
    }

    /**
     * @param timeout 加锁超时时间
     * @param nano
     * @param expire  锁的超时时间(秒),过期删除
     * @return 成功或失败标志
     */
    private boolean addLock(long timeout, long nano, int expire) {
        try {
            while ((System.nanoTime() - nano) < timeout) {
                if (this.redisTemplate.opsForValue().setIfAbsent(this.key, LOCKED)) {
                    this.redisTemplate.expire(this.key, expire, TimeUnit.SECONDS);
                    return true;
                }
                // 短暂休眠，避免出现活锁
                Thread.sleep(3, RANDOM.nextInt(500));
            }
        } catch (Exception e) {
            throw new RuntimeException("Locking error", e);
        }
        return false;
    }

    /**
     * 解锁
     */
    public void unlock() {
        try {
            if (this.locked) {
                this.redisTemplate.delete(this.key);
            }
        } catch (Exception e) {
            throw new RuntimeException("Unlock error", e);
        }
    }

    /**
     * lua脚本加锁
     */
    public void lockByScript(List<String> keys, Object... argv) {
        try {
            DefaultRedisScript redisScript =new DefaultRedisScript<>();
            redisScript.setLocation(new ClassPathResource("lua/lock.lua"));
            // 这个值类型要跟lua返回值类型一致才行，否则就会报 java.lang.IllegalStateException
            redisScript.setResultType(Integer.class);
            int result = (int)redisTemplate.execute(redisScript, keys, argv);
            System.out.println("");
        } catch (Exception e) {
            throw new RuntimeException("lock error", e);
        }

    }

    /**
     * 分布式加锁实现
     */
    public String LOCK_SCRIPT = "if redis.call('setnx', KEYS[1], ARGV[1]) == 1 then "
            + " return redis.call('expire', KEYS[1], ARGV[2]) "
            + " else return 0 end";


    /**
     * 分布式解锁实现
     */
    public String UN_LOCK_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then"
            + " return redis.call('del', KEYS[1])"
            + " else return 0 end";

    public String DECREMENT_SCRIPT = "if tonumber(redis.call('get',KEYS[1])) > 0 then "
            + " redis.call('decr',KEYS[1]) "
            + " return 1"
            + " else return 0 end";
}
