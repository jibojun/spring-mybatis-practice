package com.demo.springdemo.aspect;


public class TestClass {

    public static void main(String[] args) {
        SpringContextUtil.init("classpath:spring-context.xml");
        TestBiz t=(TestBiz)SpringContextUtil.getBean("test");
        t.externalMethod();
    }
}
