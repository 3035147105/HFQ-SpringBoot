package com.toy.server.sorting;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Gaohaiqing
 * @Date: 2018/6/22 10:53
 */
public class DecrypQQ {

    public static void main(String[] args) {
//        int [] array = {1,2,3,4,5,6,7,8,9};
//        Object[] res = decryp(array);
//        print(res);

        // 回文数数组
        String[] strings = {"3cbabc3", "haah", "haha", "123321", "12aba12"};
        for (String s : strings) {
            judgeHuiwen2(s);
        }
    }


    /**
     * 解密QQ号
     * @param array
     * @return
     */
    private static Object[] decryp(int[] array) {
        int head = 0;
        int tail = array.length - 1;
        // 数组加空间
        int[] array1 = new int[100];
        array = ArrayUtils.addAll(array, array1);

        List<Integer> res = new ArrayList<>();

        while (head != tail) {
            res.add(array[head]);
            head++;
            tail++;
            array[tail] = array[head];
            head++;
        }
        System.out.println("head==tail:" + head);
        res.add(array[head]);

        return res.toArray();
    }

    /**
     * 判断入参是否是回文数
     * 回文数：倒着读和正着读完全一样的数
     * 1.找中间值mid（mid是前半部分的最后一个数）
     * 2.找后半部分的第一个数
     * 3.分别向前向后比较（前半部分向前，后半部分向后）
     * @param s
     * 时间复杂度：O(N/2)
     */
    private static void judgeHuiwen(String s) {
        char[] c = s.toCharArray();
        int length = c.length;
        int mid = length/2 - 1;

        int start;
        if (length % 2 == 0) {
            start = mid + 1;
        } else {
            start = mid + 2;
        }
        while (start < length) {
            if (c[start] != c[mid]) {
                break;
            }
            mid--;
            start++;
        }
        if (mid == -1) {
            System.out.println(s + "是回文数");
        } else {
            System.out.println(s + "不是回文数");
        }
    }

    /**
     * 判断回文数的第二种方法
     * 回文数：倒着读和正着读完全一样的数
     * @param s
     * 时间复杂度：遍历了两遍，N是字符数：O(2N)
     */
    private static void judgeHuiwen2(String s) {
        String s1 = StringUtils.EMPTY;
        for (int i = s.length() - 1; i >= 0; i--) {
            s1 += s.charAt(i);
        }
        if (s.equals(s1)) {
            System.out.println(s + "是回文数");
        } else {
            System.out.println(s + "不是回文数");
        }
    }


    private static void print(Object[] array) {
        for (Object o : array) {
            System.out.print(o + " ");
        }
        System.out.println();
    }
}
