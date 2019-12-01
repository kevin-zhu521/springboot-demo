package com.xiaoi.service.impl;

import com.xiaoi.SpringbootredisApplicationTests;
import com.xiaoi.service.RedisLockService;
import com.xiaoi.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kevin.zhu
 * @date 2019/11/29 19:11
 */
class RedisLockServiceImplTest extends SpringbootredisApplicationTests {

    @Autowired
    private RedisLockService redisLockService;

    @Test
    void lockByScript() {
        List<String> keys = Arrays.asList("xiaoi:key");//key
        boolean result = redisLockService.lockByScript(keys, "valueeee", "100");//value,过期时间，默认秒
        System.out.println(result);
    }
}