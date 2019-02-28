package com.wyh.java.sword;

import com.wyh.java.Arithmetic;

/**
 * Created by wyh on 2019/2/28.
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class A1 implements Arithmetic {
    @Override
    public void run() {

    }

    public boolean find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int len = array[0].length;
        for (int[] anArray : array) {
            if (target == anArray[0] || target == anArray[len - 1]) {
                return true;
            }
            if (target < anArray[0]) {
                return false;
            }
            if (target < anArray[len - 1]) {
                for (int a : anArray) {
                    if (a == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
