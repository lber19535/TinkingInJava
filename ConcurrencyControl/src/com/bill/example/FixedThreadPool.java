package com.bill.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Bill on 2014/12/19.
 */
public class FixedThreadPool {

    public static void main(String[] args) {
        // if new fixed thread pool param is 1, it just like single thread pool, but have some difference
        // fixed thread pool can use to execute a number which be appoint synchronized
        // this will be used to execute some long time or performance needed task
        ExecutorService exec = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
