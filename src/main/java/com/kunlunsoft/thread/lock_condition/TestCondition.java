package com.kunlunsoft.thread.lock_condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/***
 * 我们要打印1-9这0个数字，由A线程先打印1-3，然后由B线程打印4-6，然后再由A线程打印7-9 ",<br />
 * see https://blog.csdn.net/u013256816/article/details/50445241
 */
public class TestCondition {
    private static int value = 1;
    /***
     * 可重入锁
     */
    private Lock lock = new ReentrantLock();
    private Condition Condition456 = lock.newCondition();
    private Condition Condition789 = lock.newCondition();

    public static void main(String[] args) {
        TestCondition test = new TestCondition();
        Thread threadA = new Thread(test.new ThreadA());
        Thread threadB = new Thread(test.new ThreadB());
        threadA.start();
        threadB.start();
    }

    class ThreadA implements Runnable {
        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println("A 首先输出1-3");
                while (value <= 3) {
                    System.out.println(value++);
                }
                Condition456.signal();
            } finally {
                lock.unlock();
            }

            try {
                lock.lock();
                while (value <= 6) {
                    Condition789.await();
                }
                System.out.println("A 输出7-9");
                while (value <= 9) {
                    System.out.println(value++);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    class ThreadB implements Runnable {
        @Override
        public void run() {
            try {
                lock.lock();
                while (value <= 3) {
                    Condition456.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

            try {
                lock.lock();
                System.out.println("B 输出4-6");
                while (value <= 6) {
                    System.out.println(value++);
                }
                Condition789.signal();
            } finally {
                lock.unlock();
            }
        }
    }

}
