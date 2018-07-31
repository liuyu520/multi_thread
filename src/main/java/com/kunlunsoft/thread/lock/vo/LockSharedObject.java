package com.kunlunsoft.thread.lock.vo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程不安全
 */
public class LockSharedObject {
    private int count = 0;
    private ReentrantLock reentrantLock = new ReentrantLock();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void add(int num) {
        if (!reentrantLock.tryLock()) {
            return;
        }
        count = count + num;
    }
}
