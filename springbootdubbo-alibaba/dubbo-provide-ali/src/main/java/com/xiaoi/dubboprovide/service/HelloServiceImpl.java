package com.xiaoi.dubboprovide.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaoi.dubboapi.dubbo.servcie.HelloService;
import org.springframework.stereotype.Component;

@Service
@Component
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        System.out.println("provide hello");
        return "hello" + name;
    }
}
