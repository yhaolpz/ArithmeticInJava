package com.wyh.java;

import com.wyh.java.sword.A1;

public class MyClass {

    public static void main(String[] args) {

        System.out.println("***start***");

        test().run();

    }


    private static Arithmetic test() {
        return new A1();
    }

}
