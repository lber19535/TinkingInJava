package com.bill.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Bill on 2014/12/19.
 */
public class SingleThreadPool {
    public static void main(String[] args) {
        // the different between the fixedThreadExcutor(1) is single thread pool will serialize the runnable
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
