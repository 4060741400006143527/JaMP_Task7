package com.epam.jamp.multithreading.eleven;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberThread implements Runnable {

    @Override
    public void run() {
        int i = 0;
        while (i < 10) {
            int nextInt = ThreadLocalRandom.current().nextInt(1, 100 + 1);
            System.out.println("RandomNumberThread " + nextInt);
            Main.numbers.add(i);

            i++;
        }
    }
}
