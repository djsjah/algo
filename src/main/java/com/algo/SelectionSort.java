package com.algo;

import java.util.Arrays;
import java.util.Comparator;

public final class SelectionSort {
    private SelectionSort() { }

    public static <T extends Comparable<? super T>> T[] sort(T[] array) {
        return sort(array, Comparator.naturalOrder());
    }

    public static <T> T[] sort(T[] array, Comparator<? super T> comparator) {
        if (array == null || comparator == null) {
            throw new NullPointerException("Array and comparator must not be null");
        }

        // Создается копия, чтобы не изменять исходный массив
        T[] result = Arrays.copyOf(array, array.length);

        for (int i = 0; i < result.length - 1; i++) {
            int minIndex = i;

            // Поиск минимального элемента в оставшейся части массива
            for (int j = i + 1; j < result.length; j++) {
                if (comparator.compare(result[j], result[minIndex]) < 0) minIndex = j;
            }

            // Найденный минимальный элемент ставится на текущую позицию
            if (minIndex != i) SortUtils.swap(i, minIndex, result);
        }

        return result;
    }
}
