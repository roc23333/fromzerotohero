package com.roc.jucstudy.tools;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i=0;i<10;i++)
        {
            new Thread(()->{
                try {
                    countDownLatch.countDown();
                    System.out.println(countDownLatch.getCount());
                }
                catch (Exception ex)
                {
                    //System.out.println(ex.printStackTrace());
                }
            }).start();
        }
        countDownLatch.await();
        System.out.println("sss");
    }
}
