package com.bill.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Call back from thread demo
 *
 * results list will wait the future call back the value,
 * if not the for loop will wait the thread call back
 * Created by Bill on 2014/12/22.
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        ArrayList<Future<String>> results = new ArrayList<Future<String>>();

        for (int i = 0; i < 10000; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }

        while (!results.isEmpty()){

            Iterator<Future<String>> mFutureIterator = results.listIterator();
            while (mFutureIterator.hasNext()){
                Future<String> future = mFutureIterator.next();
                try {
                    if (future.isDone()){
                        System.out.println("future = " + future.get());
                        mFutureIterator.remove();
                    }else {
                        continue;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } finally {
                    exec.shutdown();
                }
            }
//            for (Future<String> future : results) {
//                try {
//                    if (future.isDone()){
//                        System.out.println("future = " + future.get());
//                    }else {
//                        continue;
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                } finally {
//                    exec.shutdown();
//                }
//            }
        }

    }


}
