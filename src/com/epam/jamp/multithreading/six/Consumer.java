package com.epam.jamp.multithreading.six;

import java.util.List;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {

    private String name;
    private Semaphore semaphore;
    private Semaphore mutex;
    private List<Integer> queue;

    public Consumer(String name, Semaphore semaphore, Semaphore mutex, List<Integer> queue) {
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
                Integer result = queue.get(queue.size() - 1);
                queue.remove(queue.size() - 1);

                System.out.println(name + " consumes value: " + result);
                mutex.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
