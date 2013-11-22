package com.bill.learn;

/**
 * Created with IntelliJ IDEA.
 * User: bill
 * Date: 13-11-12
 * Time: 下午2:46
 * To change this template use File | Settings | File Templates.
 */
public interface Selector {
    boolean end();
    Object current();
    void next();
}
