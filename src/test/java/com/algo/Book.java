package com.algo;

public record Book(int year, String title) implements Comparable<Book> {
    @Override
    public int compareTo(Book other) { return Integer.compare(this.year, other.year); }
}
