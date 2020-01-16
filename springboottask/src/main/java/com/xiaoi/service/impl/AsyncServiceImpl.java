package com.xiaoi.service.impl;

import com.xiaoi.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

/**
 * @author kevin.zhu
 * @date 2019/3/31 10:51
 */
@Slf4j
@Service
public class AsyncServiceImpl implements AsyncService {

    @Override
    @Async("asyncServiceExecutor")
    public void asyncTask() {
        try {
            log.info(Thread.currentThread().getName() + "睡眠开始");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(Thread.currentThread().getName() + "睡眠之后");
    }
}
