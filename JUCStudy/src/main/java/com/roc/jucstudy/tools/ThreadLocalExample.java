package com.roc.jucstudy.tools;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalExample extends Thread{

   private static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(()->new String("ss"));

    public static void main(String[] args) throws IOException {


        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int j=1;
        for (int i = 0; i < 10; i++) {
            executorService.execute(()->test());
        }
        System.in.read();
    }

    public static   void test()
    {
        System.out.println(Thread.currentThread().getName()+"ss");
    }
}


