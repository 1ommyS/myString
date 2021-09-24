package com.my.string;

import java.util.*;
import java.util.function.Predicate;

/**
 * @author 1ommy
 * @version 21.09.2021
 */
public class MyString {
    private char[] string;

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

    @Override
    public String toString() {
        return String.valueOf(string);
    }
}
