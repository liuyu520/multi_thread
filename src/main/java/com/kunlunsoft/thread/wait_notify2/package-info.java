package com.kunlunsoft.thread.wait_notify2;
// 经典的生产者消费者问题
//使用 ReentrantLock.newCondition()
// 生产者只能唤醒消费者,消费者只能唤醒生产者