package com.bill.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Bill on 2014/12/25.
 */
public class DaemonFromFactory implements Runnable {
    @Override
    public void run() {
        while (true){
            try {
                TimeUnit.MICROSECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " this = " + this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            exec.execute(new DaemonFromFactory());
        }
        TimeUnit.MICROSECONDS.sleep(500);
    }
}
