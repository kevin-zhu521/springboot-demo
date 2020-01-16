package com.xiaoi.controller;

import com.xiaoi.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kevin.zhu
 * @date 2019/3/31 10:46
 */
@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("async")
    public String asyncTask(){
        for (int i = 0; i < 10; i++) {
            asyncService.asyncTask();
        }
        return "success";
    }

}
