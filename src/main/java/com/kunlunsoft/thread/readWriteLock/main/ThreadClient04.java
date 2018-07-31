package com.kunlunsoft.thread.readWriteLock.main;

import com.kunlunsoft.thread.readWriteLock.runnable.ReadWriteLockCountRunnable;
import com.kunlunsoft.thread.readWriteLock.vo.ReadWriteLockSharedObject;

/***
 * 线程不安全
 */
public class ThreadClient04 {
    public static void main(String[] args) {
        ReadWriteLockSharedObject sharedObject = new ReadWriteLockSharedObject();
        ReadWriteLockCountRunnable countRunnable = new ReadWriteLockCountRunnable(sharedObject);
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
