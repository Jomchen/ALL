package com.jomchen.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.RunnableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

/**
 * create by Jomchen on 2018/11/19
 */
public class JomchenApplication {

    public static AtomicBoolean atomicBoolean = new AtomicBoolean(Boolean.TRUE);

    public static void main(String[] args) {
        new Thread(new MyThread()).start();
        IntStream.rangeClosed(0, 20).forEach(i -> {
            boolean b = JomchenApplication.atomicBoolean.compareAndSet(Boolean.TRUE, Boolean.FALSE);
            System.out.println("main ------------> " + i + "--" + b);
        });
    }

}

class MyThread implements Runnable {

    @Override
    public void run() {
        IntStream.rangeClosed(0, 21).forEach(k -> {
            boolean b = JomchenApplication.atomicBoolean.compareAndSet(Boolean.FALSE, Boolean.TRUE);
            System.out.println("son ***** " + k + "**" + b);

        });
    }

}
