package com.toy.server.sorting;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @Author: Gaohaiqing
 * @Date: 2018/6/20 11:32
 *
 * 快排
 */
public class QuickSort {

    public static void main(String[] args) {
//        int[] array = {5, 6, 9, 4, 3, 2, 1, 8, 7};
        int[] array = {10, 15, 23, 4, 21, 19, 2, 1, 18, 7, 9, 11, 8};
//        sort(array, 0);
        practiceQS(0, array.length - 1, array);
        print(array);
    }

    /**
     * 第一代排序
     * @param array
     * @param middle
     */
    static void sort(int[] array, int middle) {
        if (array.length <= 1) {
            return;
        }

        int index = quickSort(array, array[middle]);
        print(array);
        int[] subarray = ArrayUtils.subarray(array, 0, index);
        int[] subarray1 = ArrayUtils.subarray(array, index + 1, array.length);
        sort(subarray, 0);
        sort(subarray1, 0);
    }

    /**
     * 1.让i变量指向数组的头部，j变量指向数组的底部，middle是参考数
     * 2.j从右往左移动，找比参考值小的，找到后停下；i从左往右移动，找比参考值大的数，找到后停下；
     * 3.交换j和i对应的数
     * 4.循环交换，直到i跟j相等，此时交换参考数和i或j对应的数
     * 5.返回参考数对应的下标。用于分组再比较
     * @param array
     * @param middle 作为参考的数
     * @return 下标
     */
    public static int quickSort(int[] array, int middle) {
        int j = array.length - 1;
        int i = 0;

        while (true) {
            if (i >= j) {
                break;
            }
            while (true) {
                if ((array[j] < middle) || (i >= j)) {
                    break;
                }
                j--;
            }
            while (true) {
                if ((array[i] > middle) || (i >= j)) {
                    break;
                }
                i++;
            }
            exchange(i, j, array);
        }

        // 交换第一个元素和i==j时的下标元素
        exchange(0, i, array);

        return i;
    }

    /**
     * 交换数组中两个数的位置
     * @param i
     * @param i1
     * @param array
     */
    private static void exchange(int i, int i1, int[] array) {
        int temp = array[i];
        array[i] = array[i1];
        array[i1] = temp;
    }

    /**
     * 快排
     * @param left 数组开始下标
     * @param right 数组结束下标
     * @param arrays 待排序数组
     *               最坏时间复杂度:O(N的平方)
     *               平均时间复杂度：O(NlogN)
     */
    private static void quickSorts(int left, int right, int[] arrays) {
        int i = left;
        int j = right;
        if (i > j) { // 递归结束条件
            return;
        }

        int temp = arrays[left];

        while (i != j) {
            while ((arrays[j] >= temp) && (i < j)) {
                j--;
            }
            while ((arrays[i] <= temp) && (i < j)) {
                i++;
            }
            exchange(i, j, arrays);
        }
        exchange(left, i, arrays);

        quickSorts(left, i-1, arrays);
        quickSorts(i+1, right, arrays);
    }


    // 练习快排写法
    public static void practiceQS(int left, int right, int[] array) {
        int i = left;
        int j = right;

        // 递归结束条件
        if (i > j) {
            return;
        }
        // 基准数
        int temp = array[left];
        while (i != j) {
            // j先行
            while ((array[j] >= temp) && (i < j)) {
                j--;
            }
            while ((array[i] <= temp) && (i < j)) {
                i++;
            }
            exchange(i, j, array);
        }
        // 改变基准数位置
        exchange(left, i, array);

        // 一次排序结束，递归排序所有
        practiceQS(left, i-1, array);
        practiceQS(i+1, right, array);
    }

    /**
     * 打印数组
     * @param array
     */
    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
