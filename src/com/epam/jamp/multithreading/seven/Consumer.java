package com.epam.jamp.multithreading.seven;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {

    private String name;
    private Semaphore semaphore;
    private Semaphore mutex;
    private List<MyObject> queue;

    public Consumer(String name, Semaphore semaphore, Semaphore mutex, List<MyObject> queue) {
        this.name = name;
        this.semaphore = semaphore;
        this.mutex = mutex;
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                semaphore.acquire();

                mutex.acquire();

                MyObject myObject = queue.get(ThreadLocalRandom.current().nextInt(0, queue.size()));

                System.out.println(name + " consumes value: " + myObject);
                mutex.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
