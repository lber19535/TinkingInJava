package com.bill.example;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Bill on 2014/12/22.
 */
public class TaskWithResult implements Callable<String> {

    private int taskId;
    private int waitTime;

    public TaskWithResult(int taskId) {
        Random rand = new Random(System.nanoTime());
        this.waitTime = rand.nextInt(5);
        this.taskId = taskId;
    }

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(waitTime);
        return "result with " + taskId + " watit " + waitTime;
    }
}
