package com.kunlunsoft.thread.lock.main;

import com.kunlunsoft.thread.lock.runnable.LockCountRunnable;
import com.kunlunsoft.thread.lock.vo.LockSharedObject;

/***
 * 线程不安全
 */
public class ThreadClient03 {
    public static void main(String[] args) {
        LockSharedObject sharedObject = new LockSharedObject();
        LockCountRunnable countRunnable = new LockCountRunnable(sharedObject);
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
