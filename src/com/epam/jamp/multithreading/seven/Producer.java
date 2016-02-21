package com.epam.jamp.multithreading.seven;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {

    private String producerName;
    private Semaphore semaphore;
    private Semaphore mutex;
    private List<MyObject> queue;

    public Producer(String producerName, Semaphore semaphore, Semaphore mutex, List<MyObject> queue) {
        this.producerName = producerName;
        this.semaphore = semaphore;
        this.mutex = mutex;
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                mutex.acquire();

                String name = String.valueOf(ThreadLocalRandom.current().nextInt(1, 100 + 1));
                Integer number = ThreadLocalRandom.current().nextInt(1, 100 + 1);
                MyObject myObject = new MyObject(number, name);

                queue.add(myObject);
                System.out.println(producerName + " is producing new value:" + myObject);
                mutex.release();

                semaphore.release();

                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
