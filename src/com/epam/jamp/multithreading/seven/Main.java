package com.epam.jamp.multithreading.seven;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(0);
        Semaphore mutex = new Semaphore(1);
        List<MyObject> queue = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(7);
        executorService.submit(new Producer("Producer 1", semaphore, mutex, queue));
        executorService.submit(new Producer("Producer 2", semaphore, mutex, queue));
        executorService.submit(new Consumer("Consumer 1", semaphore, mutex, queue));
        executorService.submit(new Consumer("Consumer 2", semaphore, mutex, queue));
        executorService.submit(new Consumer("Consumer 3", semaphore, mutex, queue));
        executorService.submit(new Consumer("Consumer 4", semaphore, mutex, queue));
        executorService.submit(new Consumer("Consumer 5", semaphore, mutex, queue));

        executorService.shutdown();
    }
}
