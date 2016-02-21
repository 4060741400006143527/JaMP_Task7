package com.epam.jamp.multithreading.nine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        final int SIZE = 10000;

        List<Integer> myList = new ArrayList<>(SIZE);

        for (int i = 0; i < SIZE; i++) {
            int value = (int) (Math.random() * 100);
            myList.add(value);
        }

        QuickSort<Integer> quickSort = new QuickSort<>(myList);

        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(quickSort);
    }
}
