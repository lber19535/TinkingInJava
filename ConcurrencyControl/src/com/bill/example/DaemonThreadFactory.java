package com.bill.example;

import java.util.concurrent.ThreadFactory;

/**
 * Convenience method to create daemon thread
 * Created by Bill on 2014/12/25.
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
