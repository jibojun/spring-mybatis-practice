package com.demo.springdemo.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextUtil {
    private static ApplicationContext context;

    public static void init(String contextXML){
        context=new ClassPathXmlApplicationContext(contextXML);
    }

    public static Object getBean(String name){
        return context.getBean(name);
    }

    public static Object getBean(Class clz){
        return context.getBean(clz);
    }
}
