package com.bill.example;

/**
 * Created by Bill on 2014/12/19.
 */
public class BasicThread {
    public static void main(String[] args) {
        LiftOff liftOff = new LiftOff();
        Thread thread = new Thread(liftOff);
        thread.start();
        System.out.println("waiting for lift off thread!");
    }
}
