package com.xiaoi.service.impl;

import com.xiaoi.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author kevin.zhu
 * @date 2019/3/31 10:51
 */
@Service
public class AsyncServiceImpl implements AsyncService {

    @Override
    @Async
    public void asyncTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("睡眠之后");
    }
}
