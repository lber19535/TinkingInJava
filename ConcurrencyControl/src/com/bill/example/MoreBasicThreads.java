package com.bill.example;

/**
 * Created by Bill on 2014/12/19.
 */
public class MoreBasicThreads {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("waiting for lift off thread!");
    }
}
