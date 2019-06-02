package com.wyh.java;

import com.wyh.java.sort.Sort;
import com.wyh.java.sword.A1;

import java.util.Arrays;

public class MyClass {

    public static void main(String[] args) {

        System.out.println("***start***");

//        test().run();


        System.out.println(Arrays.toString(Sort.arr));
        Sort.sort6(Sort.arr);
        System.out.println(Arrays.toString(Sort.arr));
    }


    private static Arithmetic test() {
        return new A1();
    }

}
