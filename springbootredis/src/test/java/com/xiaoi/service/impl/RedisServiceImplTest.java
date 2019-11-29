package com.xiaoi.service.impl;

import com.google.gson.Gson;
import com.xiaoi.SpringbootredisApplication;
import com.xiaoi.SpringbootredisApplicationTests;
import com.xiaoi.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kevin.zhu
 * @date 2019/11/26 11:03
 */
class RedisServiceImplTest extends SpringbootredisApplicationTests {

    @Autowired
    private RedisService redisService;

    @Test
    void lpush() {
        List<String> list = Arrays.asList("aa", "bb", "cc");
        redisService.lLeftPushAll("xiaoi:name", list);
        System.out.println("success");
    }

    @Test
    void lLeftPush() {
        redisService.lLeftPush("xiaoi:name", "dd");
        System.out.println("success");
    }
}