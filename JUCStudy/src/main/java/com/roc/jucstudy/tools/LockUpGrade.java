package com.roc.jucstudy.tools;

import org.openjdk.jol.info.ClassLayout;

public class LockUpGrade {

    public void lockUpgradeTest1() {
        Object obj = new Object();
        System.out.println("未开启偏向锁，对象信息");
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        synchronized (obj) {
            System.out.println("已获取到锁信息");
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }
        System.out.println("已释放锁信息");
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }

    public void lockUpgradeTest2() {
        Object obj = new Object();
        System.out.println("开启偏向锁，偏向锁延迟时间前，对象信息");
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        synchronized (obj) {
            System.out.println("已获取到锁信息");
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }
        System.out.println("开启偏向锁，已释放锁信息");
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }


    public void lockUpgradeTest3() {
        // JVM默认4秒后才可以偏向锁，所以这里休眠5秒，锁对象就是偏向锁了
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Object object = new Object();
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开启偏向锁，偏向锁延迟时间后，对象信息" + ClassLayout.parseInstance(object).toPrintable());
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "已获取到锁信息" + ClassLayout.parseInstance(object).toPrintable());
            }
            System.out.println(Thread.currentThread().getName() + "开启偏向锁，已释放锁信息" + ClassLayout.parseInstance(object).toPrintable());
        }, "t1");
        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        LockUpGrade lockUpGrade = new LockUpGrade();
        lockUpGrade.lockUpgradeTest3();
    }

}
