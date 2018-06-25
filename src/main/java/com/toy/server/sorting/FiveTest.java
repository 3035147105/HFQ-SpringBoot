package com.toy.server.sorting;

/**
 * @Author: Gaohaiqing
 * @Date: 2018/6/24 22:08
 *
 *
 */
public class FiveTest {

    public static void main(String[] args) {
        int n = 4;
        int m = 5;
        int[][] twoDimension = getTwoDimension();
       create(twoDimension, n, m);
    }

    /**
     * @param n 顶点数
     * @param m 边数
     * @param array
     */
    public static void create(int[][] array, int n, int m) {

        int[] a = new int[20];
        int[] b = new int[20];
        int[] c = new int[20];

        int[] first = new int[n];
        int[] next = new int[m]; // 存边数
        int k = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (array[i][j] > 0) {
                    a[k] = i;
                    b[k] = j;
                    c[k] = array[i][j];
                    k++;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            first[a[i]] = i;
            // TODO: 2018/6/24  
        }

        printOneDimensional(a, n);
    }


    /**
     * 1 4 9
     * 4 3 8
     * 1 2 5
     * 2 4 6
     * 1 3 7
     * @return
     * 顶点是4
     */
    public static int[][] getTwoDimension() {
        int[][] e = new int[10][10];
        e[1][4] = 9;
        e[1][2] = 5;
        e[1][3] = 7;
        e[2][4] = 6;
        e[4][3] = 8;

        return e;
    }


    /**
     * 打印二维数组
     * @param e
     * @param n
     */
    private static void printTwoDimensional(int[][] e, int n) {
        System.out.println("======打印二维数组======");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.println(i + "," + j +":" + e[i][j]);
            }
        }
    }

    /**
     * 打印一维数组
     * @param e
     */
    private static void printOneDimensional(int[] e, int n) {
        System.out.println("======打印一维数组======");
        for (int i = 1; i <=  e.length - 1; i++) {
            System.out.println(i + ":" + e[i]);
        }
    }

}
