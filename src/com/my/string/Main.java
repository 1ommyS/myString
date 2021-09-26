package com.my.string;

public class Main {

    public static void main(String[] args) {
        MyString myString = new MyString("howRT");
        myString.map(item -> item = 'd');

        System.out.println(myString);
    }


}
