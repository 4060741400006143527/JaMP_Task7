package com.epam.jamp.multithreading.ten;

import java.util.concurrent.locks.Lock;


public class MyThread implements Runnable {

    private final Lock lock1;
    private final Lock lock2;

    public MyThread(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {

        if (lock1.tryLock()) {
            String name = Thread.currentThread().getName();
            try {
                System.out.println(name + " acquired lock on Lock_1: " + lock1);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (lock2.tryLock()) {
                    System.out.println(name + " acquired lock on Lock_2: " + lock2);
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println(name + " released lock_2: " + lock2);
                        lock2.unlock();
                    }
                }
            } finally {
                System.out.println(name + " released lock_1: " + lock1);
                lock1.unlock();
            }
        }
    }
}
