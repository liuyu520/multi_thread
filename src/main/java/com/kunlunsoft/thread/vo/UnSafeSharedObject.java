package com.kunlunsoft.thread.vo;

/**
 * 线程不安全
 */
public class UnSafeSharedObject {
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void add(int num) {
        count = count + num;
    }
}
