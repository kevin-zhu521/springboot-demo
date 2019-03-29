package com.xiaoi.utils;

import com.xiaoi.vo.RabbitSendRequestVo;
import com.xiaoi.vo.RabbitSendResponseVo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author kevin.zhu
 * @date 2019/3/28 18:20
 */
@Component
public class RabbitSendUtil {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public RabbitSendResponseVo sendMessage(RabbitSendRequestVo rabbitSendRequestVo) {
        try {
            rabbitTemplate.convertAndSend(rabbitSendRequestVo.getExchange(), rabbitSendRequestVo.getKey(), rabbitSendRequestVo.getMessage());
            return RabbitSendResponseVo.createDefaultSucceed();
        } catch (Exception e) {
            return RabbitSendResponseVo.createFailedByMessage("发送异常");
        }
    }
}
