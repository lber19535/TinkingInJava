package com.bill.example;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Bill on 2014/12/25.
 */
public class DaemonThreadPoolExecutor extends ThreadPoolExecutor {
    public DaemonThreadPoolExecutor() {
        super(0, Integer.MAX_VALUE,60L,TimeUnit.SECONDS, new SynchronousQueue<Runnable>(),new DaemonThreadFactory());
    }
}
