package com.bill.learn;

/**
 * Created with IntelliJ IDEA.
 * User: bill
 * Date: 13-11-11
 * Time: 下午4:59
 * To change this template use File | Settings | File Templates.
 */
public class Outer {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.init();

        System.out.println("inner = " + inner);
    }

    public Inner init() {
        return new Inner();
    }


    class Inner {

    }
}
