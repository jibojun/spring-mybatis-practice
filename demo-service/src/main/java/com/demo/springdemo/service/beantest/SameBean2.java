package com.demo.springdemo.service.beantest;


/**
 * @Author: Bojun Ji
 * @Description:
 * @Date: 2018/7/17_12:38 AM
 */
public class SameBean2 {
    private String info = "bean2";

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return this.info;
    }
}
