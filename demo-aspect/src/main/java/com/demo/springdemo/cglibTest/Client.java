package com.demo.springdemo.cglibTest;

public class Client {
    public static void main(String[] args) {
        Target target=new TargetImpl();
        ProxyFactory factory=new ProxyFactory(target);
        Target proxy=factory.getProxy();
        proxy.doSomething();
    }
}
