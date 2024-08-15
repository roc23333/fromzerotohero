package com.roc.jucstudy.tools;

import java.util.Random;
import java.util.concurrent.*;

public class CyclicBarrierExample1 {
    // 请求的数量
    private static final int threadCount = 4;
    // 需要同步的线程数量
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Random rand = new Random();
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("future1 done...");
            }
            return "abc";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("future2 done...");
            }
            return "efg";
        });
        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(future1, future2);
        System.out.println(completableFuture.isDone());
        completableFuture.join();
        System.out.println(completableFuture.isDone());
        System.out.println("all futures done...");
        System.out.println(completableFuture.get());
    }
}

