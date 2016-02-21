package com.epam.jamp.multithreading.eleven;

import com.epam.jamp.multithreading.six.Consumer;
import com.epam.jamp.multithreading.six.Producer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static List<Integer> numbers = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new RandomNumberThread());
        executorService.submit(new NumberSumThread());
        executorService.submit(new SquareThread());


        executorService.shutdown();

    }


}
