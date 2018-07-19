package com.demo.springdemo.service.beantest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Bojun Ji
 * @Description:
 * @Date: 2018/7/17_12:38 AM
 */
public class SameBeanTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-context1.xml", "classpath:spring-context2.xml");
        ((ClassPathXmlApplicationContext) ctx).setAllowBeanDefinitionOverriding(false);
        ((ClassPathXmlApplicationContext) ctx).refresh();
        Object obj = ctx.getBean("springBean");
        System.out.println(obj.toString());
    }
}
