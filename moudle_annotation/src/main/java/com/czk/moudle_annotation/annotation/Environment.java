package com.czk.moudle_annotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 动态切换app的一些配置的注解
 * 切换网络环境
 * create by czk at 2019-11-25
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface Environment {

    /**
     * 当前环境的具体地址，必须指定具体的值
     */
    String url();

    /**
     * 正式还是测试
     */
    boolean isRelease() default false;

    /**
     * 如果十多个module指定是哪一个module的
     */
    String alias() default "";


}