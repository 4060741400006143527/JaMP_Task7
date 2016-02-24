package com.epam.jamp.multithreading.seven;

import java.util.List;
import java.util.concurrent.*;

public class Consumer implements Runnable {

    private String name;
    private Phaser phaser;
    private List<MyObject> queue;

    public Consumer(String name, Phaser phaser, List<MyObject> queue) {
        this.name = name;
        this.phaser = phaser;
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true) {

            phaser.register();

            MyObject myObject = queue.get(ThreadLocalRandom.current().nextInt(0, queue.size()));

            System.out.println(name + " consumes value: " + myObject);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
