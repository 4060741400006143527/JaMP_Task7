package com.epam.jamp.multithreading.seven;

import java.util.List;
import java.util.concurrent.*;

public class Producer implements Runnable {

    private String producerName;
    private Phaser phaser;
    private Semaphore mutex;
    private List<MyObject> queue;

    public Producer(String producerName, Phaser phaser, Semaphore mutex, List<MyObject> queue) {
        this.producerName = producerName;
        this.phaser = phaser;
        this.mutex = mutex;
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {

                System.out.println(producerName +" waiting for all consumers");
                if (phaser.getArrivedParties() != 0) {
                    phaser.arriveAndDeregister();
                }
                System.out.println("All consumers finished. " + producerName +" started producing");

                mutex.acquire();

                String name = String.valueOf(ThreadLocalRandom.current().nextInt(1, 100 + 1));
                Integer number = ThreadLocalRandom.current().nextInt(1, 100 + 1);
                MyObject myObject = new MyObject(number, name);

                queue.add(myObject);
                System.out.println(producerName + " is producing new value:" + myObject);
                mutex.release();

//                if (phaser.getArrivedParties() != 0) {
//                    phaser.bulkRegister(3);
//                }

                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
