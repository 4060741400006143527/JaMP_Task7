package com.epam.jamp.multithreading.eleven;

import java.util.List;

public class NumberSumThread implements Runnable {


    @Override
    public void run() {
        int i = 0;
        while (i < 10) {
            Integer sum = 0;
            for (Integer number : Main.numbers) {
                sum += number;
            }
            System.out.println("NumberSumThread " + sum);
            i++;
        }
    }
}
