package com.kunlunsoft.thread.wait_notify2.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Producer06 {
    public static final int max_limit = 30;
    private SharedProduct sharedProduct;


    public void add(int num) {
        this.sharedProduct.lock();
        int total = this.sharedProduct.getTotal();
        while (total > max_limit) {
            System.out.println(Thread.currentThread() + "-生产者不用生产,当前容量 :" + total);
//                this.sharedProduct.notifyAll();//容量满了 也应该通知
            try {
                this.sharedProduct.producerCondi.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(10 + new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.sharedProduct.add(num);
        System.out.println(Thread.currentThread() + "-生产者生产 :" + num);
        this.sharedProduct.consumerCondi.signalAll();
        sharedProduct.unlock();
    }
}
