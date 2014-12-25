package com.bill.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This demo shows that the set priority method is not work fine,
 * so do not try to use priority to change thread order.
 *
 * When i read <thinking in java>, author write that priority and yield
 * can run with correct moment, but java 6 and java 5 have difference release
 * in Hotspot, that makes these two methods will not work fine with what your think.
 * So, I google some information about these, and the result is practically never use
 * these two method to try to influence threads action.
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
        // the priority is not work fine and look like not useful
        Thread.currentThread().setPriority(priority);
        while (true){
            for (int i = 0; i < 1000000; i++) {
                d += (Math.PI + Math.E) / (double)i;
                // if comment the yield method, the threads action also is random
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
