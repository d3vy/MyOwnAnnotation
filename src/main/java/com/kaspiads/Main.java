package com.kaspiads;

public class Main {
    public static void main(String[] args) {
        Cat myCat = new Cat("Bob");

        if (myCat.getClass().isAnnotationPresent(VeryImportant.class)) {
            System.out.println("Very important");
        } else {
            System.out.println("nah");
        }
    }
}