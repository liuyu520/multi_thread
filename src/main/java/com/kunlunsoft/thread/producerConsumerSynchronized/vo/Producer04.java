package com.kunlunsoft.thread.producerConsumerSynchronized.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Producer04 {
    public static final int max_limit = 30;
    private SharedProduct sharedProduct;


    public void add(int num) {
        synchronized (sharedProduct) {
            int total = this.sharedProduct.getTotal();
            if (total > max_limit) {
                System.out.println("生产者不用生产,当前容量 :" + total);
                return;
            }
            try {
                Thread.sleep(10 + new Random().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.sharedProduct.add(num);
            System.out.println("生产者生产 :" + num);
        }
    }
}
