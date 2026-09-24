package com.algo;

import java.util.Arrays;
import java.util.Comparator;

public final class QuickSort {
    private QuickSort() { }

    public static <T extends Comparable<? super T>> T[] sort(T[] array) {
        return sort(array, Comparator.naturalOrder());
    }

    public static <T> T[] sort(T[] array, Comparator<? super T> comparator) {
        if (array == null || comparator == null) {
            throw new NullPointerException("Array and comparator must not be null");
        }

        // Создается копия, чтобы не изменять исходный массив
        T[] result = Arrays.copyOf(array, array.length);

        quickSort(0, result.length - 1, result, comparator);
        return result;
    }

    private static <T> void quickSort(int left, int right, T[] array, Comparator<? super T> comparator) {
        if (left >= right) return;

        // pivot размещается на его итоговой позиции
        int pivotIndex = partition(left, right, array, comparator);

        // Рекурсивно сортируются левая и правая части
        quickSort(left, pivotIndex - 1, array, comparator);
        quickSort(pivotIndex + 1, right, array, comparator);
    }

    private static <T> int partition(int left, int right, T[] array, Comparator<? super T> comparator) {
        // В качестве pivot используется последний элемент диапазона
        T pivot = array[right];

        int smallerElementIndex = left;
        for (int currentIndex = left; currentIndex < right; currentIndex++) {
            if (comparator.compare(array[currentIndex], pivot) <= 0) {
                SortUtils.swap(smallerElementIndex, currentIndex, array);
                smallerElementIndex++;
            }
        }

        SortUtils.swap(smallerElementIndex, right, array);
        return smallerElementIndex;
    }
}
