package com.kunlunsoft.thread.vo;

/**
 * 线程安全的<br />
 * 因为使用了同步锁 synchronized <br />
 */
public class SafeSharedObject {
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public synchronized void add(int num) {
        count = count + num;
    }
}
