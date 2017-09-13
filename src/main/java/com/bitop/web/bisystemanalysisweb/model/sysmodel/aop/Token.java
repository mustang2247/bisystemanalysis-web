package com.bitop.web.bisystemanalysisweb.model.sysmodel.aop;

import java.lang.annotation.*;

/**
 * Token注解类
 * 要求方法中一定要有参数 HttpServletRequest 与 HttpServletResponse
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Token {
    boolean save() default false ;

    boolean remove() default false ;
}