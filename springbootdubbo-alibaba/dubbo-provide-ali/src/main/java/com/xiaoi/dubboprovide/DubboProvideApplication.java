package com.xiaoi.dubboprovide;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubboConfiguration
@SpringBootApplication
public class DubboProvideApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboProvideApplication.class, args);
    }

}
