package com.demo.springdemo.cglibTest;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;


public class ProxyFactory implements MethodInterceptor {
    private Target target;

    public ProxyFactory(Target target){
        this.target=target;
    }

    public Target getProxy(){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return (Target)enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long start=System.currentTimeMillis();
        Object result=method.invoke(target,objects);
        long end=System.currentTimeMillis();
        System.out.println("execution time is "+(end-start)+"ms");
        return result;
    }
}
