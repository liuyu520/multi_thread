package com.kunlunsoft.thread.wait_notify2.vo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 经典的生产者消费者问题
 */
public class SharedProduct {
    /***
     * 当前库存的产品数量
     */
    private int total = 0;
    public ReentrantLock reentrantLock = new ReentrantLock();

    public Condition producerCondi = reentrantLock.newCondition();
    public Condition consumerCondi = reentrantLock.newCondition();

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    /***
     * 生产
     * @param num
     */
    public void add(int num) {
        this.total = this.total + num;
    }

    /***
     * 消费
     * @param num
     */
    public void sub(int num) {
        this.total = this.total - num;
    }

    public void lock() {
        this.reentrantLock.lock();
    }

    public void unlock() {
        this.reentrantLock.unlock();
    }
}
