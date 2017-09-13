package com.bitop.web.bisystemanalysisweb.model.sysmodel.aop;

import java.lang.annotation.*;

/**
 * RequestLimit 注解类
 * 要求方法中一定要有参数 HttpServletRequest
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface RequestLimit {

    /**
     *
     * 允许访问的次数，默认值MAX_VALUE
     */
    int count() default Integer.MAX_VALUE;

    /**
     *
     * 时间段，单位为毫秒，默认值一分钟
     */
    long time() default 60000;

}
