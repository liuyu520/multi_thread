package com.kunlunsoft.thread.wait_notify2.main;

import com.kunlunsoft.thread.wait_notify2.vo.Consumer06;
import com.kunlunsoft.thread.wait_notify2.vo.Producer06;
import com.kunlunsoft.thread.wait_notify2.vo.SharedProduct;

/***
 * 经典的生产者消费者问题
 */
public class ThreadClient10 {
    private static SharedProduct sharedProduct = new SharedProduct();
    private static Consumer06 consumer02 = new Consumer06(sharedProduct);
    private static Producer06 producer02 = new Producer06(sharedProduct);

    public static void main(String[] args) {

        Runnable consumerRunnable = new Runnable() {
            @Override
            public void run() {
                consumer02.eat(10);
            }
        };

        Runnable producerRunnable = new Runnable() {
            @Override
            public void run() {
                producer02.add(11);
            }
        };
        int times = 20;
        for (int i = 0; i < times; i++) {
            new Thread(consumerRunnable).start();
            new Thread(producerRunnable).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(consumerRunnable).start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(producerRunnable).start();
        }
    }
}
