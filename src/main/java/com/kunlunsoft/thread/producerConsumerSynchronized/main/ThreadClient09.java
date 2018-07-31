package com.kunlunsoft.thread.producerConsumerSynchronized.main;

import com.kunlunsoft.thread.producerConsumerSynchronized.vo.Consumer04;
import com.kunlunsoft.thread.producerConsumerSynchronized.vo.Producer04;
import com.kunlunsoft.thread.producerConsumerSynchronized.vo.SharedProduct;

/***
 * 经典的生产者消费者问题
 */
public class ThreadClient09 {
    private static SharedProduct sharedProduct = new SharedProduct();
    private static Consumer04 consumer02 = new Consumer04(sharedProduct);
    private static Producer04 producer02 = new Producer04(sharedProduct);

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
