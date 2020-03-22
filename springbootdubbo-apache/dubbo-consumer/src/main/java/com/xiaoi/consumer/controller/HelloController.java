package com.xiaoi.consumer.controller;

import com.xiaoi.dubboapi.dubbo.servcie.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Reference
    private HelloService helloService;

    @GetMapping("hello/{name}")
    public String hello(@PathVariable String name) {
        return helloService.sayHello(name);
    }

}
