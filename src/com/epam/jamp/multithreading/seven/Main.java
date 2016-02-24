package com.epam.jamp.multithreading.seven;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Phaser cyclicBarrier = new Phaser(0);
        Semaphore mutex = new Semaphore(1);
        List<MyObject> queue = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(7);
        executorService.submit(new Producer("Producer 1", cyclicBarrier, mutex, queue));
        executorService.submit(new Producer("Producer 2", cyclicBarrier, mutex, queue));
        executorService.submit(new Consumer("Consumer 1", cyclicBarrier, queue));
        executorService.submit(new Consumer("Consumer 2", cyclicBarrier, queue));
        executorService.submit(new Consumer("Consumer 3", cyclicBarrier, queue));
        executorService.submit(new Consumer("Consumer 4", cyclicBarrier, queue));
        executorService.submit(new Consumer("Consumer 5", cyclicBarrier, queue));

        executorService.shutdown();
    }
}
