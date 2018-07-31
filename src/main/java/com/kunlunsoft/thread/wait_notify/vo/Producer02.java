package com.kunlunsoft.thread.wait_notify.vo;

import lombok.Data;

import java.util.Random;

@Data
public class Producer02 {
    public static final int max_limit = 30;
    private SharedProduct sharedProduct;

    public Producer02(SharedProduct sharedProduct) {
        this.sharedProduct = sharedProduct;
    }

    public void add(int num) {
        synchronized (sharedProduct) {
            int total = this.sharedProduct.getTotal();
            while (total > max_limit) {
                System.out.println(Thread.currentThread() + "-生产者不用生产,当前容量 :" + total);
                try {
                    this.sharedProduct.wait();
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
            this.sharedProduct.notifyAll();
        }
    }
}
