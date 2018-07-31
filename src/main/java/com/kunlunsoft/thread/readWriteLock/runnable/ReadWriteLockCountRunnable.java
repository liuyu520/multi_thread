package com.kunlunsoft.thread.readWriteLock.runnable;

import com.kunlunsoft.thread.readWriteLock.vo.ReadWriteLockSharedObject;
import lombok.Data;

@Data
public class ReadWriteLockCountRunnable implements Runnable {
    private ReadWriteLockSharedObject sharedObject;

    public ReadWriteLockCountRunnable(ReadWriteLockSharedObject sharedObject) {
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
