package com.bill.example;

import java.util.concurrent.Callable;

/**
 * Created by Bill on 2014/12/22.
 */
public class TaskWithResult implements Callable<String> {

    private int taskId;

    public TaskWithResult(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public String call() throws Exception {

        return "result with " + taskId;
    }
}
