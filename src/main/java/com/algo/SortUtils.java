package com.algo;

final class SortUtils {
    private SortUtils() { }

    static <T> void swap(int first, int second, T[] array) {
        T temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
