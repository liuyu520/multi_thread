package com.kunlunsoft.thread.runnable;

import com.kunlunsoft.thread.vo.UnSafeSharedObject;
import lombok.Data;

@Data

public class CountRunnable implements Runnable {
    private UnSafeSharedObject sharedObject;

    public CountRunnable(UnSafeSharedObject sharedObject) {
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
