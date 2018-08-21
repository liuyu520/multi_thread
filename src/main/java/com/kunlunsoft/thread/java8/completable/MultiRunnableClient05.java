package com.kunlunsoft.thread.java8.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/***
 * @date : 2018-08-21   中国标准时间 下午11:04:15
 * 无返回值
 */
public class MultiRunnableClient05 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture completableFuture = CompletableFuture.runAsync(() -> {
            String value = "Hello,world";
            System.out.println("value :" + value);
        }).thenRun(() -> {
            System.out.println("thenRun :");
        });
    }
}
