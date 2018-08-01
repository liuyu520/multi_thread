package com.kunlunsoft.thread.wait_notify.vo;

import com.time.util.TimeHWUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Consumer02 {
    private SharedProduct sharedProduct;


    /***
     * 消费
     * @param num
     */
    public void eat(int num) {
        synchronized (sharedProduct) {
            while (this.sharedProduct.getTotal() < num) {
                System.out.println(Thread.currentThread() + "消费者,容量不够 :" + this.sharedProduct.getTotal());
                System.out.println(Thread.currentThread() + "消费者开始阻塞 :" + TimeHWUtil.getCurrentDateTime());
                try {
                    this.sharedProduct.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "消费者阻塞结束 :" + TimeHWUtil.getCurrentDateTime());
            }
            try {
                Thread.sleep(10 + new Random().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.sharedProduct.sub(num);
            System.out.println(Thread.currentThread() + "消费者消费 ###:" + num);
            this.sharedProduct.notifyAll();

        }

    }
}
