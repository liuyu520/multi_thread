package com.kunlunsoft.thread.atomicInteger.main;

import com.kunlunsoft.thread.atomicInteger.runnable.AtomicIntegerCountRunnable;
import com.kunlunsoft.thread.atomicInteger.vo.AtomicIntegerSharedObject;

/***
 * 线程安全 ,使用atomic wrapper class如atomicInteger，或者使用自己保证原子的操作，则等同于synchronized
 */
public class ThreadClient05 {
    public static void main(String[] args) {
        AtomicIntegerSharedObject sharedObject = new AtomicIntegerSharedObject();
        AtomicIntegerCountRunnable countRunnable = new AtomicIntegerCountRunnable(sharedObject);
        new Thread(countRunnable, "a").start();
        new Thread(countRunnable, "b").start();
        new Thread(countRunnable, "c").start();
        new Thread(countRunnable, "d").start();
        new Thread(countRunnable, "e").start();
        new Thread(countRunnable, "f").start();
        new Thread(countRunnable, "g").start();
        new Thread(countRunnable, "h").start();
        /*try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
//        System.out.println("result :" + sharedObject.getCount());
    }
}
