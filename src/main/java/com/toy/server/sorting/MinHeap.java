package com.toy.server.sorting;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Gaohaiqing
 * @Date: 2018/6/20 11:33
 *
 * 一：最小堆：1.首先是一个完全二叉树（从根到叶子节点的编号是连续的）2.父节点的值小于子节点的值
 * 二：堆排序
 */
public class MinHeap {

    public static void main(String[] args) {
        int[] array = {10, 15, 23, 4, 21, 19, 2, 1, 18, 7, 9, 11, 8};
        Object[] objects = heapSort(array);
        print(objects);
    }

    /**
     * 堆排序，利用最小堆的特性：根结点比其他所有结点都要小
     * 1.创建最小堆
     * 2.将根结点保存到另一个数组中
     * 3.将最后一个结点赋给根结点
     * 重复上面3步，直到待排序数组只有一个结点
     * @param array 待排序数组
     * @return
     */
    public static Object[] heapSort(int[] array) {
        List<Integer> res = new ArrayList<>();
        int temp;
        while (array.length > 0) {
            createMinHeap(array);
            temp = array[0];
            res.add(temp);
            array[0] = array[array.length - 1];
            // 截取掉最后一位数
            array = ArrayUtils.subarray(array, 0, array.length - 1);
        }
        return res.toArray();
    }

    public static void createMinHeap(int[] array) {
        int n = array.length;
        for (int i = n/2; i>=0 ; i--) {
            down(array, i);
        }
    }

    /**
     *
     * @param array
     * @param i 向下调整的元素下标
     */
    public static void down(int[] array, int i) {
        int n = array.length; // 结点的个数
        int t; //与目标元素交换的位置
        int flag = 0; // 是否继续比较的标识，0-继续比较，1-停止比较

        while ((i*2 < n) && (flag == 0)) {

            if ((array[i] > array[i*2])) {
                t = i * 2;
            } else {
                t = i;
            }
            // 比较右子结点
            if ((i*2 + 1) < n) {
                if (array[t] > array[i*2 + 1]) {
                    t = i*2 + 1;
                }
            }
            // 交换位置
            if (i != t) {
                swap(i, t, array);
                i = t;
            } else {
                flag = 1;
            }
        }
    }

    /**
     * 交换
     * @param i 待交换元素下标一
     * @param t 待交换元素下标二
     * @param array
     */
    private static void swap(int i, int t, int[] array) {
        int temp = array[i];
        array[i] = array[t];
        array[t] = temp;
    }

    /**
     * 打印数组
     * @param array
     */
    public static void print(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
