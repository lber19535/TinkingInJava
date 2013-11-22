package com.bill.learn;

/**
 * Created with IntelliJ IDEA.
 * User: bill
 * Date: 13-11-22
 * Time: 下午4:23
 * To change this template use File | Settings | File Templates.
 */
public class Callbacks {
    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        System.out.println("-------------");
        MyIncrement.f(c2);
        System.out.println("-------------");

        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackReference());
        System.out.println("-------------");
        caller1.go();
        System.out.println("-------------");
        caller1.go();
        System.out.println("-------------");
        caller2.go();
        System.out.println("-------------");
        caller2.go();
        System.out.println("-------------");
    }
}

interface Incrementable {
    void increment();
}

class Callee1 implements Incrementable {
    private int i = 0;

    @Override
    public void increment() {
        i++;
        System.out.println("i = " + i);
    }
}

class MyIncrement {
    public void increment() {
        System.out.println("other option");
    }

    static void f(MyIncrement myIncrement) {
        myIncrement.increment();
    }
}

class Callee2 extends MyIncrement {
    private int i = 0;

    @Override
    public void increment() {
        super.increment();    //To change body of overridden methods use File | Settings | File Templates.
        i++;
        System.out.println("i = " + i);
    }

    private class Closure implements Incrementable {
        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }

    Incrementable getCallbackReference() {
        return new Closure();
    }
}

class Caller{
    private Incrementable callbackReference;

    Caller(Incrementable incrementable) {
        this.callbackReference = incrementable;
    }

    void go() {
        callbackReference.increment();
    }
}

