package com.kunlunsoft.thread.producerConsumerSynchronized.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Consumer04 {

    private SharedProduct sharedProduct;

    public void eat(int num) {
        synchronized (sharedProduct) {
            if (this.sharedProduct.getTotal() < num) {
                System.out.println("消费者,容量不够 :" + this.sharedProduct.getTotal());
            }
            try {
                Thread.sleep(10 + new Random().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.sharedProduct.sub(num);
            System.out.println("消费者消费 :" + num);
        }

    }
}
