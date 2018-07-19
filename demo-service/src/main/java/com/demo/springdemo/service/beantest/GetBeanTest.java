package com.demo.springdemo.service.beantest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Bojun Ji
 * @Description:
 * @Date: 2017/7/20_12:24 AM
 */
public class GetBeanTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-context3.xml");
        TestBean3 bean = (TestBean3) ctx.getBean("testBean");
        System.out.println(bean.getData());
        BeanOwner beanOwner=(BeanOwner)ctx.getBean("beanOwner");
        System.out.println(beanOwner.getBean().getData());
    }
}
