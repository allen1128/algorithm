package com.xl.algo;


import java.util.ArrayList;
import java.util.List;

public class MyCalendar {
    public static class Book {
        int fst;
        int snd;

        public Book(int fst, int snd) {
            this.fst = fst;
            this.snd = snd;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "fst=" + fst +
                    ", snd=" + snd +
                    '}';
        }
    }

    List<Book> books;

    public MyCalendar() {
        books = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        if (books.size() == 0) {
            books.add(new Book(start, end));
            return true;
        }

        int left = 0;
        int right = books.size() - 1;

        while (left + 1 < right) {
            int mid = left + (right - left ) / 2;
            if (books.get(mid).fst > start) {
                right = mid;
            } else {
                left = mid;
            }
        }

        int index = -1;

        if (books.get(right).fst <= start) {
            index = right;
        } else if (books.get(left).fst < start ){
            index = left;
        }


        if (index == -1) {
            if (end <= books.get(0).fst) {
                books.add(0, new Book(start, end));
                return true;
            }
        } else if (index == books.size() - 1) {
            if (books.get(index).snd <= start) {
                books.add(books.size(), new Book(start, end));
                return true;
            }
        } else if (books.get(index).snd <= start && end <= books.get(index + 1).fst) {
            books.add(index + 1, new Book(start, end));
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        MyCalendar mc = new MyCalendar();
        System.out.println(mc.book(20, 29));
        System.out.println(mc.book(13, 22));
        System.out.println(mc.book(44, 50));
        System.out.println(mc.book(1, 7));
        System.out.println(mc.book(2, 10));
        System.out.println(mc.book(14, 20));
        System.out.println(mc.book(19, 25));
        System.out.println(mc.books);
    }
}
