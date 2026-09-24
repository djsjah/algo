package com.algo;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {
    @Test
    void sortsIntegerArrayInAscendingOrder() {
        Integer[] input = { 5, 2, 7, 8, 1, 6, 3 };
        Integer[] result = QuickSort.sort(input);

        assertArrayEquals(new Integer[] { 1, 2, 3, 5, 6, 7, 8 }, result);
    }

    @Test
    void sortsIntegerArrayInDescendingOrder() {
        Integer[] input = { 5, 2, 7, 8, 1, 6, 3 };
        Integer[] result = QuickSort.sort(input, Comparator.reverseOrder());

        assertArrayEquals(new Integer[] { 8, 7, 6, 5, 3, 2, 1 }, result);
    }

    @Test
    void sortsArrayWithDuplicates() {
        Integer[] input = { 4, 2, 4, 1, 2 };
        Integer[] result = QuickSort.sort(input);

        assertArrayEquals(new Integer[] { 1, 2, 2, 4, 4 }, result);
    }

    @Test
    void sortsAlreadySortedArray() {
        Integer[] input = { 1, 2, 3, 4 };
        Integer[] result = QuickSort.sort(input);

        assertArrayEquals(new Integer[] { 1, 2, 3, 4 }, result);
    }

    @Test
    void sortsReverseSortedArray() {
        Integer[] input = { 5, 4, 3, 2, 1 };
        Integer[] result = QuickSort.sort(input);

        assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, result);
    }

    @Test
    void handlesEmptyArray() {
        Integer[] input = { };
        Integer[] result = QuickSort.sort(input);

        assertArrayEquals(new Integer[] { }, result);
    }

    @Test
    void handlesSingleElementArray() {
        Integer[] input = { 5 };
        Integer[] result = QuickSort.sort(input);

        assertArrayEquals(new Integer[] { 5 }, result);
    }

    @Test
    void doesNotModifyOriginalArray() {
        Integer[] input = { 5, 4 };
        Integer[] original = input.clone();

        QuickSort.sort(input);
        assertArrayEquals(original, input);
    }

    @Test
    void sortsStrings() {
        String[] input = { "Thomas", "Minho", "Newt" };
        String[] result = QuickSort.sort(input);

        assertArrayEquals(new String[] { "Minho", "Newt", "Thomas" }, result);
    }

    @Test
    void sortsObjectsUsingComparator() {
        Person[] input = {
                new Person(35, "Thomas"),
                new Person(20, "Newt"),
                new Person(27, "Minho")
        };

        Person[] result = QuickSort.sort(input, Comparator.comparingInt(Person::age));

        assertEquals("Newt", result[0].name());
        assertEquals("Minho", result[1].name());
        assertEquals("Thomas", result[2].name());
    }

    @Test
    void sortsComparableObjectsByNaturalOrder() {
        Book[] input = {
                new Book(2011, "The Death Cure"),
                new Book(2009, "The Maze Runner"),
                new Book(2010, "The Scorch Trials")
        };

        Book[] result = QuickSort.sort(input);

        assertEquals("The Maze Runner", result[0].title());
        assertEquals("The Scorch Trials", result[1].title());
        assertEquals("The Death Cure", result[2].title());
    }

    @Test
    void sortsTwoElementArray() {
        Integer[] input = { 2, 1 };
        Integer[] result = QuickSort.sort(input);

        assertArrayEquals(new Integer[] { 1, 2 }, result);
    }

    @Test
    void sortsArrayWithAllElementsEqual() {
        Integer[] input = { 5, 5, 5, 5 };
        Integer[] result = QuickSort.sort(input);

        assertArrayEquals(new Integer[] { 5, 5, 5, 5 }, result);
    }

    @Test
    void throwsExceptionWhenArrayIsNull() {
        assertThrows(
                NullPointerException.class,
                () -> QuickSort.sort(null)
        );
    }

    @Test
    void throwsExceptionWhenComparatorIsNull() {
        Integer[] input = { 3, 2, 1 };

        assertThrows(
                NullPointerException.class,
                () -> QuickSort.sort(input, null)
        );
    }

    @Test
    void throwsExceptionWhenArrayContainsNullWithNaturalOrder() {
        Integer[] input = { 3, null, 1 };

        assertThrows(
                NullPointerException.class,
                () -> QuickSort.sort(input)
        );
    }

    @Test
    void sortsArrayContainingNullUsingCustomComparator() {
        Integer[] input = { 3, null, 1, 2 };
        Integer[] result = QuickSort.sort(input, Comparator.nullsLast(Comparator.naturalOrder()));

        assertArrayEquals(new Integer[] { 1, 2, 3, null }, result);
    }
}
