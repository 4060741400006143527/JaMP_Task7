package com.epam.jamp.multithreading.six;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {

    private String name;
    private Semaphore semaphore;
    private Semaphore mutex;
    private List<Integer> queue;

    public Producer(String name, Semaphore semaphore, Semaphore mutex, List<Integer> queue) {
        this.name = name;
        this.semaphore = semaphore;
        this.mutex = mutex;
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            while (true) {
                Integer randomInt = ThreadLocalRandom.current().nextInt(1, 100 + 1);

                mutex.acquire();
                queue.add(randomInt);
                System.out.println(name + " is producing new value: " + randomInt);
                mutex.release();

                semaphore.release();
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
