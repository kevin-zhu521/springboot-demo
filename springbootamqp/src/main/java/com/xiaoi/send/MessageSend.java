package com.xiaoi.send;

import com.xiaoi.utils.RabbitSendUtil;
import com.xiaoi.vo.RabbitSendRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kevin.zhu
 * @date 2019/3/28 18:30
 */
@Service
public class MessageSend {

    @Autowired
    private RabbitSendUtil rabbitSendUtil;

    public void sendMessage() {
        RabbitSendRequestVo<String> message = new RabbitSendRequestVo<>();
        message.setExchange("topicExchange");
        message.setMessage("哈哈，又一次调用");
        rabbitSendUtil.sendMessage(message);
    }


}
