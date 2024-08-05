package com.example.testjavafx.jvm;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class Test {


    @SneakyThrows
    public static void main(String[] args) {

        System.out.println(Child1.str1);

    }

}

class Parent1{
    public static String str1 = "hello";

    static {
        System.out.println("Parent1 static blocks");
    }

}

class Child1 extends Parent1{
    public static String str2 = "world";

    static {
        System.out.println("Child static blocks");
    }

}
