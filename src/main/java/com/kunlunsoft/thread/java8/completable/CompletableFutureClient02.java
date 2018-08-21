package com.kunlunsoft.thread.java8.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/***
 * @date : 2018-08-21   中国标准时间 下午11:04:15
 * 有返回值
 */
public class CompletableFutureClient02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "Hello world";
            }
        });
        String value = completableFuture.get();
        System.out.println("value :" + value);
    }
}