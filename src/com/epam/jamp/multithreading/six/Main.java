package com.epam.jamp.multithreading.six;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(0);
        Semaphore mutex = new Semaphore(1);
        List<Integer> queue = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(7);
        executorService.submit(new Producer("Producer1", semaphore, mutex, queue));
        executorService.submit(new Producer("Producer2", semaphore, mutex, queue));
        executorService.submit(new Consumer("Consumer1", semaphore, mutex, queue));
        executorService.submit(new Consumer("Consumer2", semaphore, mutex, queue));
        executorService.submit(new Consumer("Consumer3", semaphore, mutex, queue));
        executorService.submit(new Consumer("Consumer4", semaphore, mutex, queue));
        executorService.submit(new Consumer("Consumer5", semaphore, mutex, queue));

        executorService.shutdown();
    }
}
