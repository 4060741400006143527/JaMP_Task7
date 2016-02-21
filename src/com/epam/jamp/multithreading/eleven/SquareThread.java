package com.epam.jamp.multithreading.eleven;

import java.util.List;

public class SquareThread implements Runnable {

    @Override
    public void run() {
        int i = 0;
        while (i < 10) {
            double sum = 0;
            for (Integer number : Main.numbers) {
                double sqrt = Math.pow(number, number);
                sum += sqrt;

            }
            System.out.println("SquareThread " + Math.sqrt(sum));
            i++;
        }
    }
}
