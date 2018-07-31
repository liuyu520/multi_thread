package com.kunlunsoft.thread.lock.vo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程安全 ,使用 ReentrantLock
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
        reentrantLock.lock();

        //业务逻辑
        count = count + num;

        //必须要释放锁,最好放在finaly语句块中
        reentrantLock.unlock();
    }
}
