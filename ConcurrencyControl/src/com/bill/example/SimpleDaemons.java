package com.bill.example;

import java.util.concurrent.TimeUnit;

/**
 *
 * When the main thread is closed, the daemon threads will be killed
 * change the wait time with run method and main thread can check the phenomenon
 *
 * Created by Bill on 2014/12/25.
 */
public class SimpleDaemons implements Runnable{
    @Override
    public void run() {
        while (true){
            try {
                TimeUnit.MICROSECONDS.sleep(1000);
                System.out.println(Thread.currentThread() + " this = " + this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("all daemons stared");
        TimeUnit.MICROSECONDS.sleep(175);
    }
}
