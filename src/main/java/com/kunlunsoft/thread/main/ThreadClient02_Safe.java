package com.kunlunsoft.thread.main;

import com.kunlunsoft.thread.runnable.SafeCountRunnable;
import com.kunlunsoft.thread.vo.SafeSharedObject;

/***
 * 线程安全
 */
public class ThreadClient02_Safe {
    public static void main(String[] args) {
        SafeSharedObject sharedObject = new SafeSharedObject();
        SafeCountRunnable countRunnable = new SafeCountRunnable(sharedObject);
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
