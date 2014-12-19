package com.bill.example;

/**
 * Created by Bill on 2014/12/19.
 */
public class LiftOff implements Runnable {

    private static int taskCount = 0;
    private final int id = taskCount++;
    protected int countDown = 10;   //default countdown time

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "Lift Off!")
                + ")  ";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }
}