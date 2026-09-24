package com.algo;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SelectionSortTest {
    @Test
    void sortsIntegerArrayInAscendingOrder() {
        Integer[] input = { 7, 2, 9, 1, 5 };
        Integer[] result = SelectionSort.sort(input);

        assertArrayEquals(new Integer[] { 1, 2, 5, 7, 9 }, result);
    }

    @Test
    void sortsIntegerArrayInDescendingOrder() {
        Integer[] input = { 7, 2, 9, 1, 5 };
        Integer[] result = SelectionSort.sort(input, Comparator.reverseOrder());

        assertArrayEquals(new Integer[] { 9, 7, 5, 2, 1 }, result);
    }

    @Test
    void sortsArrayWithDuplicates() {
        Integer[] input = { 3, 1, 3, 2, 1 };
        Integer[] result = SelectionSort.sort(input);

        assertArrayEquals(new Integer[] { 1, 1, 2, 3, 3 }, result);
    }

    @Test
    void sortsAlreadySortedArray() {
        Integer[] input = { 1, 2, 3, 4, 5 };
        Integer[] result = SelectionSort.sort(input);

        assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, result);
    }

    @Test
    void sortsReverseSortedArray() {
        Integer[] input = { 5, 4, 3, 2, 1 };
        Integer[] result = SelectionSort.sort(input);

        assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, result);
    }

    @Test
    void handlesEmptyArray() {
        Integer[] result = SelectionSort.sort(new Integer[] { });
        assertArrayEquals(new Integer[] { }, result);
    }

    @Test
    void handlesSingleElementArray() {
        Integer[] result = SelectionSort.sort(new Integer[] { 10 });
        assertArrayEquals(new Integer[] { 10 }, result);
    }

    @Test
    void doesNotModifyOriginalArray() {
        Integer[] input = { 3, 2, 1 };
        Integer[] original = input.clone();

        SelectionSort.sort(input);
        assertArrayEquals(original, input);
    }

    @Test
    void sortsStrings() {
        String[] input = { "Thomas", "Minho", "Newt" };
        String[] result = SelectionSort.sort(input);

        assertArrayEquals(new String[] { "Minho", "Newt", "Thomas" }, result);
    }

    @Test
    void sortsObjectsUsingComparator() {
        Person[] input = {
                new Person(35, "Thomas"),
                new Person(20, "Newt"),
                new Person(27, "Minho")
        };

        Person[] result = SelectionSort.sort(input, Comparator.comparingInt(Person::age));

        assertArrayEquals(
                new Person[] {
                        new Person(20, "Newt"),
                        new Person(27, "Minho"),
                        new Person(35, "Thomas")
                },
                result
        );
    }

    @Test
    void sortsComparableObjectsByNaturalOrder() {
        Book[] input = {
                new Book(2011, "The Death Cure"),
                new Book(2009, "The Maze Runner"),
                new Book(2010, "The Scorch Trials")
        };

        Book[] result = SelectionSort.sort(input);

        assertArrayEquals(
                new Book[] {
                        new Book(2009, "The Maze Runner"),
                        new Book(2010, "The Scorch Trials"),
                        new Book(2011, "The Death Cure")
                },
                result
        );
    }

    @Test
    void sortsTwoElementArray() {
        Integer[] input = { 2, 1 };
        Integer[] result = SelectionSort.sort(input);

        assertArrayEquals(new Integer[] { 1, 2 }, result);
    }

    @Test
    void sortsArrayWithAllElementsEqual() {
        Integer[] input = { 5, 5, 5, 5 };
        Integer[] result = SelectionSort.sort(input);

        assertArrayEquals(new Integer[] { 5, 5, 5, 5 }, result);
    }

    @Test
    void throwsExceptionWhenArrayIsNull() {
        assertThrows(
                NullPointerException.class,
                () -> SelectionSort.sort(null)
        );
    }

    @Test
    void throwsExceptionWhenComparatorIsNull() {
        Integer[] input = { 3, 2, 1 };

        assertThrows(
                NullPointerException.class,
                () -> SelectionSort.sort(input, null)
        );
    }

    @Test
    void throwsExceptionWhenArrayContainsNullWithNaturalOrder() {
        Integer[] input = { 3, null, 1 };

        assertThrows(
                NullPointerException.class,
                () -> SelectionSort.sort(input)
        );
    }

    @Test
    void sortsArrayContainingNullUsingCustomComparator() {
        Integer[] input = { 3, null, 1, 2 };
        Integer[] result = SelectionSort.sort(
                input,
                Comparator.nullsLast(Comparator.naturalOrder())
        );

        assertArrayEquals(new Integer[] { 1, 2, 3, null }, result);
    }
}
