package com.xiaoi.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author kevin.zhu
 * @date 2019/3/28 18:24
 */
@Data
public class RabbitSendResponseVo implements Serializable {

    private static final long serialVersionUID = -3129047071247239433L;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 消息
     */
    private String message;

    public RabbitSendResponseVo() {
    }

    public RabbitSendResponseVo(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    /**
     * 成功调用
     *
     * @return 发送响应类
     */
    public static RabbitSendResponseVo createDefaultSucceed() {
        return new RabbitSendResponseVo(StatusEnum.SUCCESS.code, StatusEnum.SUCCESS.getMessage());
    }

    /**
     * 自定义失败调用
     *
     * @return 发送响应类
     */
    public static RabbitSendResponseVo createFailed(Integer code, String message) {
        return new RabbitSendResponseVo(code == StatusEnum.SUCCESS.code ? -1 : code, message);
    }

    /**
     * 失败调用
     *
     * @param message 失败信息
     * @return 发送响应类
     */
    public static RabbitSendResponseVo createFailedByMessage(String message) {
        return new RabbitSendResponseVo(StatusEnum.FAILED.getCode(), message);
    }

    /**
     * 默认失败调用
     *
     * @param message 失败信息
     * @return 发送响应类
     */
    public static RabbitSendResponseVo createDefaultFailed() {
        return new RabbitSendResponseVo(StatusEnum.FAILED.getCode(), StatusEnum.FAILED.getMessage());
    }


    public static enum StatusEnum {
        SUCCESS(0, "success"),
        FAILED(-1, "failed"),;

        private Integer code;
        private String message;

        StatusEnum(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
