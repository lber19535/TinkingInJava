package com.bill.example;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * the print is not sort by some seq, the seq depend on the platform and jvm type
 * Created by Bill on 2014/12/22.
 */
public class SleepingTask extends LiftOff{

    @Override
    public void run() {
        while (countDown-- > 0){
            System.out.print(status());
            Random random = new Random(System.nanoTime());
            int second = random.nextInt(10);
            try {
                TimeUnit.SECONDS.sleep(second);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("second = " + second);
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}
