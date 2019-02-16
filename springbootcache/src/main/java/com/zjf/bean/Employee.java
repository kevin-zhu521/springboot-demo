package com.zjf.bean;

import lombok.Data;

/**
 * Created by Kevin Zhu on 2019/2/1 22:51 .
 */
@Data
public class Employee {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 姓名
     */
    private String lastName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别(0:男 1：女)
     */
    private Integer gender;

    /**
     * 部门id
     */
    private Integer dId;
}
