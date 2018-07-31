package com.kunlunsoft.thread.wait_notify.vo;

import lombok.Data;

import java.util.Random;

@Data
public class Consumer02 {
    private SharedProduct sharedProduct;

    public Consumer02(SharedProduct sharedProduct) {
        this.sharedProduct = sharedProduct;
    }

    public void eat(int num) {
        if (this.sharedProduct.getTotal() >= num) {
            try {
                Thread.sleep(10 + new Random().nextInt(20));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.sharedProduct.sub(num);
            System.out.println("消费者消费 :" + num);
        } else {
            System.out.println("消费者,容量不够 :" + this.sharedProduct.getTotal());
        }
    }
}
