package com.kunlunsoft.thread.runnable;

import com.kunlunsoft.thread.vo.SafeSharedObject;
import lombok.Data;

@Data

public class SafeCountRunnable implements Runnable {
    private SafeSharedObject sharedObject;

    public SafeCountRunnable(SafeSharedObject sharedObject) {
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
