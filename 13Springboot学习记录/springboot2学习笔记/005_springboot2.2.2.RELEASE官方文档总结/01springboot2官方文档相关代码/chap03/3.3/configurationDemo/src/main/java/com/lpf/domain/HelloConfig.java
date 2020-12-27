package com.lpf.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {

    /**
     * 装配一个 beanName 为 helloMsg 的实例
     *
     * @author lpf
     * @date 2020/12/20 21:04
     */
    @Bean("helloMsg")
    public Hello configHello(){
        System.out.println("自定义一个Hello类，它的msg属性为helloMsg");
        Hello hello = new Hello();
        hello.setMsg("helloMsg");
        return hello;

    }
}
