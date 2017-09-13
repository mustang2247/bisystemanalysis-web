package com.bitop.web.bisystemanalysisweb.model.sysmodel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


//    当访问根路径或者 /index 路径时，将会跳转到 index.html 页面。
//    访问/login 路径时，将会跳转到 login.html 页面。
//    登陆失败，将会重定向到/login-error 路径时，最终会跳转到 login.html 页面。其中，在页面里面，我们绑定了错误提示信息。

    /**
     * 自定义配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/fonts/**", "/index").permitAll()  // 虽都可以访问
                .antMatchers("/users/**").hasRole("USER")   // 需要响应的角色才能访问
                .and()
                .formLogin()   //基于 Form 表单登录验证
                .loginPage("/login").failureUrl("/login-error");
    }

    /**
     * 认证信息管理
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()  // 认证信息存储于没内存中
                .withUser("waylau").password("123456").roles("USER");
    }
}