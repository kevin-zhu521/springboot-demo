package com.zjf.aspect.log;

import lombok.Data;

/**
 * @author kevin.zhu
 * @date 2019/3/29 10:31
 */
@Data
public class SysLogBO {

    private String className;

    private String methodName;

    private String params;

    private Object result;

    private Long exeuTime;

    private String remark;

    private String createDate;


}
