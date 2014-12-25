package com.bill.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * this demo shows that the set priority method is not work fine,
 * so do not try to use priority to change thread order
 *
 * Created by Bill on 2014/12/24.
 */
public class SimplePriorities implements Runnable {

    private int countDown = 5;
    private volatile double d;
    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true){
            for (int i = 0; i < 1000000; i++) {
                d += (Math.PI + Math.E) / (double)i;
                if ((i % 10000) == 0){
                    Thread.yield();
                }
            }
            System.out.println("this = " + this);
            if (--countDown == 0)
                return;
        }
    }

    @Override
    public String toString() {
        return Thread.currentThread() + " : "+ countDown;
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}
