package com.xiaoi.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author kevin.zhu
 * @date 2019/3/28 18:24
 */
@Data
public class RabbitSendRequestVo<T>  implements Serializable{

    private static final long serialVersionUID = -3129047071247239433L;

    /**
     * 发送路由
     */
    private String exchange;

    /**
     * 发送消息key
     */
    private String key;

    /**
     * 发送消息
     */
    private T message;
}
