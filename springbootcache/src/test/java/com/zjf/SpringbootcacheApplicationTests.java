package com.zjf;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootcacheApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void contextLoads() {
    }

    /**
     * stringRedisTemplate.opsForList().leftPush("emplist","fffff");
     * stringRedisTemplate.opsForValue().append("emp:"+3,"sdfsfffffff");
     * stringRedisTemplate.opsForValue().set("emp:"+4,"sdfsfffffff");
     * stringRedisTemplate.opsForHash().put("emphash:","key2","ssd");
     * String s = stringRedisTemplate.opsForValue().get("emp:1");
     * String s=redisTemplate.opsForList().leftPop("emplist");
     * List<String> s=(List<String>)stringRedisTemplate.opsForList().range("emplist", 0, -1);
     */
    //按照key存放，key一样则覆盖，如果不想覆盖而是拼接使用append命令
    @Test
    public void setRedisStringTest() {
        stringRedisTemplate.opsForValue().set("emp", "StringTest");
    }

    @Test
    public void getRedisStringTest() {
        String result = stringRedisTemplate.opsForValue().get("emp");
        System.out.println(result);
    }

    //rightPushAll是以正常思维存进去，rang命令取出来的也是按照list的顺序
    @Test
    public void setRedisListTest() {
        ArrayList<String> al = Lists.newArrayList();
        al.add("a");
        al.add("b");
        stringRedisTemplate.opsForList().rightPushAll("emplistright", al);
    }

    @Test
    public void getRedisListTest() {
        List<String> al = stringRedisTemplate.opsForList().range("emplistright", 0, -1);
        System.out.println(al.get(0)+": "+ al.get(1));
    }

    @Test
    public void setRedisHashTest() {
        Map<String, String> mp = new HashMap<>();
        mp.put("a","11");
        mp.put("b","22");
        stringRedisTemplate.opsForHash().putAll("empmap", mp);
    }

    @Test
    public void getRedisHashTest() {
        Map<Object, Object> mp = stringRedisTemplate.opsForHash().entries("empmap");
        for (Object o : mp.keySet()) {
            System.out.println(o+" : "+mp.get(o));
        }
    }
}

