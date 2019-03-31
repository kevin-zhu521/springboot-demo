package com.xiaoi.service.impl;

import com.xiaoi.service.ScheduleService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author kevin.zhu
 * @date 2019/3/31 10:59
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Override
    @Scheduled(cron = "0 * * * * ?")
    public void scheduleTask() {
        System.out.println("定时");
    }
}
