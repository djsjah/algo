package com.algo;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = { 8, 3, 7, 1, 9, 2, 5 };
        String[] characters = { "Gandalf", "Frodo", "Aragorn", "Legolas", "Gimli", "Sam" };

        System.out.println("Original numbers:   " + Arrays.toString(numbers));
        System.out.println("QuickSort asc:      " + Arrays.toString(QuickSort.sort(numbers)));
        System.out.println("QuickSort desc:     " + Arrays.toString(QuickSort.sort(
                numbers, Comparator.reverseOrder()
        )));

        System.out.println("SelectionSort asc:  " + Arrays.toString(SelectionSort.sort(numbers)));
        System.out.println("SelectionSort desc: " + Arrays.toString(SelectionSort.sort(
                numbers, Comparator.reverseOrder()
        )));

        System.out.println();

        System.out.println("Original strings:   " + Arrays.toString(characters));
        System.out.println("QuickSort asc:      " + Arrays.toString(QuickSort.sort(characters)));
        System.out.println("QuickSort desc:     " + Arrays.toString(QuickSort.sort(
                characters, Comparator.reverseOrder()
        )));

        System.out.println("SelectionSort asc:  " + Arrays.toString(SelectionSort.sort(characters)));
        System.out.println("SelectionSort desc: " + Arrays.toString(SelectionSort.sort(
                characters, Comparator.reverseOrder()
        )));
    }
}