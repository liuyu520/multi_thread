package com.kunlunsoft.thread.wait_notify.main;

import com.common.util.SystemHWUtil;
import com.kunlunsoft.thread.wait_notify.vo.Consumer02;
import com.kunlunsoft.thread.wait_notify.vo.Producer02;
import com.kunlunsoft.thread.wait_notify.vo.SharedProduct;

/***
 * 经典的生产者消费者问题
 */
public class ThreadClient08 {
    private static SharedProduct sharedProduct = new SharedProduct();
    private static Consumer02 consumer02 = new Consumer02(sharedProduct);
    private static Producer02 producer02 = new Producer02(sharedProduct);

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
        System.out.println(" :" + SystemHWUtil.DIVIDING_LINE);
        for (int i = 0; i < 5; i++) {
            new Thread(producerRunnable).start();
        }
    }
}
