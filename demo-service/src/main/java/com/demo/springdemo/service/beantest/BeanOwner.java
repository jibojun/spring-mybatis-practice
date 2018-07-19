package com.demo.springdemo.service.beantest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Author: Bojun Ji
 * @Description:
 * @Date: 2017/7/20_12:30 AM
 */
@Component("beanOwner")
public class BeanOwner {
    @Autowired
    @Qualifier("testBean")
    private TestBean3 bean;

    public TestBean3 getBean() {
        return bean;
    }

    public void setBean(TestBean3 bean) {
        this.bean = bean;
    }
}
