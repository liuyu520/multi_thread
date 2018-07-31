package com.kunlunsoft.thread.producerConsumer.main;

import com.kunlunsoft.thread.producerConsumer.vo.Consumer03;
import com.kunlunsoft.thread.producerConsumer.vo.Producer03;
import com.kunlunsoft.thread.wait_notify.vo.SharedProduct;

/***
 * 经典的生产者消费者问题
 */
public class ThreadClient09 {
    private static SharedProduct sharedProduct = new SharedProduct();
    private static Consumer03 consumer02 = new Consumer03(sharedProduct);
    private static Producer03 producer02 = new Producer03(sharedProduct);

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

    }
}
