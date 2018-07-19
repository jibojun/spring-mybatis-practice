package com.demo.springdemo.service.beantest;

import org.springframework.stereotype.Component;

/**
 * @Author: Bojun Ji
 * @Description:
 * @Date: 2017/7/20_12:23 AM
 */
@Component("testBean")
public class TestBean3 {
    private String data = "test1";

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
