package com.kunlunsoft.thread.readWriteLock.vo;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 线程安全 <br />
 * 可重入的读写锁:ReentrantReadWriteLock <br />
 */
public class ReadWriteLockSharedObject {
    private int count = 0;
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void add(int num) {
        writeLock.lock();
        //业务逻辑
        count = count + num;

        //必须要释放锁,最好放在finaly语句块中
        writeLock.unlock();
    }
}
