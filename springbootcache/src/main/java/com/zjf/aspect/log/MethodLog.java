package com.zjf.aspect.log;

import java.lang.annotation.*;

/**
 * 监听每个方法传入的参数、返回值，打印日志
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MethodLog {

    /**
     * @return 方法描述
     */
    String value() default "";

}
