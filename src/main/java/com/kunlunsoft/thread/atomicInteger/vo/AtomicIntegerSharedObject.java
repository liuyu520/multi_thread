package com.kunlunsoft.thread.atomicInteger.vo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程安全 ,使用atomic wrapper class如atomicInteger，或者使用自己保证原子的操作，则等同于synchronized
 */
public class AtomicIntegerSharedObject {
    private AtomicInteger count = new AtomicInteger(0);

    public int getCount() {
        return count.get();
    }

    public void setCount(int count) {
        this.count.set(count);
    }

    public void add(int num) {

        //业务逻辑
        count.addAndGet(num);

    }
}
