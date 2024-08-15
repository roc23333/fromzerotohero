package com.roc.jucstudy.tools;

import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedDEmo {
    ReentrantLock lock ;

    public SynchronizedDEmo(ReentrantLock lock)
    {
        this.lock = lock;
    }
    public  void method1()  {
        try {
            lock.lock();
            System.out.println("方法1");
            Thread.sleep(5000);
            lock.unlock();
        }
        catch (Exception e) {

        }
    }

    public   void method2() {
        try {
            lock.lock();
            System.out.println("方法2");
            Thread.sleep(5000);
            lock.unlock();
        }
        catch (Exception e) {

        }
    }


    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();
        SynchronizedDEmo s1 = new SynchronizedDEmo(lock);
        SynchronizedDEmo s2 = new SynchronizedDEmo(lock2);
        ThreadLocal<String> stringThreadLocal = ThreadLocal.withInitial(String::new);
        stringThreadLocal.get();
        new Thread(s1::method1).start();
        new Thread(s2::method2).start();
    }
}
