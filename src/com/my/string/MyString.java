package com.my.string;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * @author 1ommy
 * @version 21.09.2021
 */
public class MyString implements Iterable, Iterator{
    private char[] string;
    private int currentIndex = -1;

    public MyString(char[] string) {
        this.string = string;
    }

    public MyString(String string) {
        this.string = string.toCharArray();
    }

    public MyString add(char symbol) {
        char[] temp = new char[string.length + 1];
        System.arraycopy(string, 0, temp, 0, string.length);
        temp[string.length] = symbol;
        string = temp;
        return new MyString(string);
    }

    public MyString delete(char symbol) {
        char[] result = new char[string.length - 1];
        int last_insert = 0;
        for (int i = 0; i < string.length; i++) {
            if (string[i] == symbol)
                i++;

            result[last_insert++] = string[i];
        }
        string = result;
        return new MyString(string);
    }

    public MyString replace(char originalSymbol, char newSymbol) {
        for (int i = 0; i < string.length; i++) {
            if (string[i] == originalSymbol) {
                string[i] = newSymbol;
            }
        }
        return new MyString(string);
    }

    public MyString filter(Predicate<Character> predicate) {
        List<Character> list = new ArrayList<>();
        for (char c : string) {
            if (predicate.test(c)) {
                list.add(c);
            }
        }
        string = list.toString().toCharArray();
        return new MyString(string);
    }

    public void map(UnaryOperator<Character> characterUnaryOperator) {
        List<Character> list = new ArrayList<>();
        for (char c : string) {
            list.add(characterUnaryOperator.apply(c));
        }
        string = list.toString().toCharArray();
    }

    public void sort(Comparator<Character> comparator) {
        boolean isSort;
        char temp;
        int offset = 0;
        do {
            isSort = true;

            for (int i = 0; i < string.length - 1 - offset; i++) {
                if (comparator.compare(string[i], string[i + 1]) < 0) {
                    temp = string[i];
                    string[i] = string[i + 1];
                    string[i + 1] = temp;

                    isSort = false;
                }
            }

            offset++;
        }
        while (!isSort);
    }

    @Override
    public String toString() {
        return String.valueOf(string);
    }

    @Override
    public Iterator iterator() {
        currentIndex = -1;
        return this;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < string.length-1;
    }

    @Override
    public Object next() {
        return string[++currentIndex];
    }
}
