package com.kunlunsoft.thread.lock.runnable;

import com.kunlunsoft.thread.lock.vo.LockSharedObject;
import lombok.Data;

@Data
public class LockCountRunnable implements Runnable {
    private LockSharedObject sharedObject;

    public LockCountRunnable(LockSharedObject sharedObject) {
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
