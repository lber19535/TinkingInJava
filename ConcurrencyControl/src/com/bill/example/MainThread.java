package com.bill.example;

/**
 * Created by Bill on 2014/12/19.
 */
public class MainThread {
    public static void main(String[] args) {
        // runnabel inject to main thread
        LiftOff liftOff = new LiftOff();
        liftOff.run();

    }


}
