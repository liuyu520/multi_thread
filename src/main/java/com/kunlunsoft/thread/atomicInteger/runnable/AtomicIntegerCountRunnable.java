package com.kunlunsoft.thread.atomicInteger.runnable;

import com.kunlunsoft.thread.atomicInteger.vo.AtomicIntegerSharedObject;
import lombok.Data;

/***
 * 如果使用atomic wrapper class如atomicInteger，或者使用自己保证原子的操作，则等同于synchronized
 */
@Data
public class AtomicIntegerCountRunnable implements Runnable {
    private AtomicIntegerSharedObject sharedObject;

    public AtomicIntegerCountRunnable(AtomicIntegerSharedObject sharedObject) {
        this.sharedObject = sharedObject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            sharedObject.add(1);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " count :" + sharedObject.getCount());

        }
    }
}
