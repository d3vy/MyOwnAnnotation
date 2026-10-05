package com.kaspiads;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Cat myCat = new Cat("Bob");

        if (myCat.getClass().isAnnotationPresent(VeryImportant.class)) {
            System.out.println("Very important");
        } else {
            System.out.println("nah");
        }

        for (Method method : myCat.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(RunImmediately.class)) {
                RunImmediately annotation = method.getAnnotation(RunImmediately.class);
                for (int i = 0; i < annotation.times(); i++) {
                    method.invoke(myCat);
                }
            }
        }

        for (Field f : myCat.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(ImportantString.class)) {
               Object obj = f.get(myCat);
            }
        }
    }
}