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
    public static void sort1(int[] array) {
        // 需要走（array.length-1）趟，每趟的目的就是把最大值放最后边
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {  // 比较相邻两数的大小，大的放后边
                    swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * 插入排序
     * 时间复杂度：O(n2)
     */
    public static void sort2(int[] array) {
        // 需要走（array.length-1）趟，每趟的目的是排好一个(i+1)的队列
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (array[j] < array[j - 1]) { // 比较相邻两数的大小，插入到已排序序列的合适的位置
                    swap(array, j, j - 1);
                }
            }
        }
    }

    /**
     * 选择排序
     * 时间复杂度：O(n2)
     */
    public static void sort3(int[] array) {
        // 需要走（array.length-1）趟，每趟的目的就是找到遍历的最小数交换到前面
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length - 1; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(array, minIndex, i);
            }
        }
    }

    /**
     * 快排
     * 时间复杂度：O(nlogn)
     * https://blog.csdn.net/shujuelin/article/details/82423852
     */
    public static void sort4(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array,
                                 final int startIndex,
                                 final int endIndex) {
        if (startIndex > endIndex) {
            return;
        }
        final int temp = array[startIndex]; //开始位置数做基准值
        int i = startIndex; //开始位置
        int j = endIndex; //结束位置
        while (i < j) {
            //先从右端开始向左遍历，若小于基准位则停止
            while (array[j] >= temp && i < j) {
                j--;
            }
            //再从左端开始向右遍历，若大于基准位则停止
            while (array[i] <= temp && i < j) {
                i++;
            }
            //右边定位到了小于基准位的值，左边定位到了大于基准位的值，满足条件，交换
            if (i < j) {
                swap(array, i, j);
            }
        }
        //从右向左和从左向右的遍历已经到达同一位置，i等于j，将基准位和这个位置交换
        swap(array, startIndex, i);
        //递归处理左半列表
        quickSort(array, startIndex, i - 1);
        //递归处理右半列表
        quickSort(array, i + 1, endIndex);
    }


    /**
     * 归并排序
     * 时间复杂度：O(nlogn)
     */
    public static void sort5(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    public static void mergeSort(int[] array,
                                 final int startIndex,
                                 final int endIndex) {
        if (startIndex < endIndex) { //对数组分组，分到每个子序列只有一个元素为止
            int mid = (startIndex + endIndex) / 2; //从中间对半分
            mergeSort(array, startIndex, mid); //对左侧子序列进行递归排序
            mergeSort(array, mid + 1, endIndex); //对右侧子序列进行递归排序
            merge(array, startIndex, mid, endIndex); //合并两个有序的子序列
        }
    }

    public static void merge(int[] array,
                             final int startIndex,
                             final int mid,
                             final int endIndex) {
        int[] temp = new int[array.length];//辅助数组
        int p1 = startIndex; //第一个子序列的索引
        int p2 = mid + 1; //第二个子序列的索引
        int p = startIndex; //存放的位置
        while (p1 <= mid && p2 <= endIndex) {
            if (array[p1] <= array[p2]) { //对比这两个有序子序列，哪个小就取哪个
                temp[p++] = array[p1++];
            } else {
                temp[p++] = array[p2++];
            }
        }
        while (p1 <= mid) { //如果第一个序列没有检测完，则直接全部合并到后边
            temp[p++] = array[p1++];
        }
        while (p2 <= endIndex) { //同上，但不会出现两个序列都没检测完的情况
            temp[p++] = array[p2++];
        }
        for (int i = startIndex; i <= endIndex; i++) {//写回原数组
            array[i] = temp[i];
        }
    }

    /**
     * 希尔排序
     */
    public static void sort6(int[] array) {
        int gap = array.length;
        while (gap > 0) {
            gap /= 2; //分组间隔,从数组长度开始每次/2
            for (int i = 0; i < gap; i++) { //按gap分组
                for (int j = i + gap; j < array.length; j += gap) { //遍历分好的组，从第二个元素开始
                    //插入排序
                    final int temp = array[j]; //要插入的元素
                    int k = j - gap; //有序序列的最后一位
                    while (k >= 0 && temp < array[k]) { //从后往前遍历有序序列进行插入
                        array[k + gap] = array[k]; //若要插入的元素小于有序序列此位置上的值，就往后移动有序序列
                        k -= gap; //往后移动
                    }
                    //移动完毕，插入
                    array[k + gap] = temp;
                }
            }
        }
    }

    /**
     * 堆排序
     */
    public static void sort7(int[] array) {

    }

    /**
     * 基数排序
     */
    public static void sort8(int[] array) {

    }


    /**
     * 交换数据
     */
    private static void swap(int[] array, int i, int j) {
        //1.临时变量法
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
        //2.算数法
//        array[i] = array[i] + array[j];
//        array[j] = array[i] - array[j];
//        array[i] = array[i] - array[j];
        //3.位运算法
//        array[i] = array[i] ^ array[j];
//        array[j] = array[i] ^ array[j]; //array[i]^array[j]^array[j]=array[i]
//        array[i] = array[i] ^ array[j]; //array[i]^array[j]^array[i]=array[j]
    }

    public static int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
//    public static int[] arr = {2, 7, 2, 4, 7, 1, 3, 4};
//    public static int[] arr = {5, 2, 2, 4};

}
