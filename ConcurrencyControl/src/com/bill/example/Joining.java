package com.bill.example;

import java.util.concurrent.TimeUnit;

/**
 * Created by Bill on 2014/12/25.
 */
public class Joining {

    public static void main(String[] args) {
        Thread
                sleeper = new Thread(new Sleeper(1500), "Sleepy"),
                grumpy = new Thread(new Sleeper(1500), "Grumpy");
        Thread
                dpepy = new Thread(new Joiner(sleeper), "Dpepy"),
                doc = new Thread(new Joiner(grumpy), "Doc");

        sleeper.start();
        grumpy.start();
        dpepy.start();
        doc.start();

        grumpy.interrupt();

    }

}

class Sleeper implements Runnable {

    private int sleepTime;

    public Sleeper(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        try {
            TimeUnit.MICROSECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
//            e.printStackTrace();
            System.out.println("e = " + e);
        }
        System.out.println(Thread.currentThread().getName() + " awakened" );
    }
}

class Joiner implements Runnable {

    private Thread thread;

    public Joiner(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " complete" );
    }
}