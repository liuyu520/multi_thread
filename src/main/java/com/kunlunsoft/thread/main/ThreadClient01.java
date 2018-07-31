package com.kunlunsoft.thread.main;

import com.kunlunsoft.thread.runnable.CountRunnable;
import com.kunlunsoft.thread.vo.UnSafeSharedObject;

public class ThreadClient01 {
    public static void main(String[] args) {
        UnSafeSharedObject sharedObject = new UnSafeSharedObject();
        CountRunnable countRunnable = new CountRunnable(sharedObject);
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
