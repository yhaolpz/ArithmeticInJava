package com.wyh.java.sort;

/**
 * Created by wyh on 2019/3/26.
 * 排序算法
 */
public class Sort {

    /**
     * 冒泡排序
     * 时间复杂度：O(n2)
     */
    public static void bubbleSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) { // 需要走（array.length-1）趟，每趟的目的就是把最大值放最后边
            for (int j = i; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {  // 比较相邻两数的大小，大的放后边
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * 时间复杂度：O(n2)
     */
    public static void selectSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) { // 需要走（array.length-1）趟，每趟的目的就是找到最小值并换到最前边
            int minIndex = i;
            for (int j = i; j < array.length - 1; j++) {
                if (array[j] < array[j + 1]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    /**
     * 插入排序
     * 时间复杂度：O(n2)
     */
    public static void insertSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) { // 需要走（array.length-1）趟，每趟的目的是排好一个(i+1)的队列
            for (int j = i + 1; j > 0; j--) {
                if (array[j] < array[j - 1]) { // 插入方式类似冒泡
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

}
