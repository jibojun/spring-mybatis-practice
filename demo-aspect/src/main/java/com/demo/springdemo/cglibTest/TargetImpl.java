package com.demo.springdemo.cglibTest;

public class TargetImpl implements Target {
    public void doSomething() {
        for(int i=0;i<3;i++) {
            new Thread(() -> System.out.println(Thread.currentThread().getName() + " is running!")).start();
        }
    }
}
