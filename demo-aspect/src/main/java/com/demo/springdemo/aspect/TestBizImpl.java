package com.demo.springdemo.aspect;

import org.springframework.stereotype.Service;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service("test")
public class TestBizImpl implements TestBiz {
    public void externalMethod() {
        System.out.println("external method started");
        ((TestBiz)SpringContextUtil.getBean("test")).doSomething();
    }

    public void doSomething() {

        ExecutorService threadPool= Executors.newSingleThreadExecutor();
        threadPool.submit(new Thread(() -> {
            System.out.println("start a thread and wait for 5S");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        threadPool.shutdown();
        try {
            threadPool.awaitTermination(100,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
