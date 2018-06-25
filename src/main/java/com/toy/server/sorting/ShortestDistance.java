package com.toy.server.sorting;

/**
 * @Author: Gaohaiqing
 * @Date: 2018/6/22 18:00
 *
 * 求多个点之间的最短路径
 * 求单个点到其他点的最短路径
 * x = 99999999
 */
public class ShortestDistance {
    // 近似于看成无限大
    static final int x = 99999999;

    public static void main(String[] args) {
        // 6个顶点，
        int n = 6;
        int[][] array = createTwo(n);
        int[] dis = createDis(1, array, n);
        distanceTwo(dis, array, n , 1);
        printOneDimensional(dis, n);
    }

    /**
     * 重写单顶点距离各顶点的距离
     * @param dis 存储1号顶点到各顶点的距离
     * @param array 二维数组
     * @param n 总顶点数
     * @param i 确定的下一个距离1号顶点最近的值
     */
    private static void distanceTwo(int[] dis, int[][] array, int n, int i) {
        int min = 99999;
        int s = 1;
        // 找到离1号顶点最近的顶点
        for (int j = 1; j <= n; j++) {
            if (array[i][j] > 0 && array[i][j] <= min) {
                min = array[i][j];
                s = j;
            }
        }
        // 递归调用的结束条件
        if (s == n) {
            return;
        }

        // 更新dis数组得值
        for (int j = 1; j <= n; j++) {
            if (dis[j] > dis[s] + array[s][j]) {
                dis[j] = dis[s] + array[s][j];
            }
        }

        distanceTwo(dis, array, n, s);
    }

    /**
     *    1  2  3  4
     * 1  0  4  1  3
     * 2  x  0  x  2
     * 3  x  2  0  x
     * 4  x  x  5  0
     * 中间的是边的距离，即顶点x到顶点y的距离
     * @param n 顶点个数
     */
    private static void create(int n, int[][] e) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    e[i][j] = 0;
                } else {
                    e[i][j] = x;
                }
            }
        }

        // 6条边
        e[1][2] = 4;
        e[1][3] = 1;
        e[1][4] = 3;
        e[2][4] = 2;
        e[3][2] = 2;
        e[4][3] = 5;
    }

    /**
     * 处理后：
     *    1  2  3  4
     * 1  0  3  1  3
     * 2  x  0  7  2
     * 3  x  2  0  4
     * 4  x  7  5  0
      * @param n
     * @param e
     */
    private static void distance(int n, int[][] e) {
        // 比较

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (e[i][j] > e[i][k] + e[k][j]) {
                        e[i][j] = e[i][k] + e[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.println(i + "城到" + j + "城的最短距离是:" + e[i][j]);
            }
        }
    }


    /**
     * 创建二维数组
     * 走一波，求单点到各个顶点的最短距离
     * @param n 顶点个数
     */
    private static int[][] createTwo(int n) {
        int[][] arr = new int[50][50];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = x;
                }
            }
        }

        arr[1][2] = 1;
        arr[1][3] = 12;
        arr[2][3] = 9;
        arr[2][4] = 3;
        arr[3][5] = 5;
        arr[4][3] = 4;
        arr[4][5] = 13;
        arr[4][6] = 15;
        arr[5][6] = 4;

        return arr;
    }

    /**
     * 初始化顶点i到各顶点的初始距离
     * @param i  要求的顶点
     * @param arr 已经初始化好的数组
     * @param n 顶点总个数
     * @return
     */
    private static int[] createDis(int i, int[][] arr, int n) {
        if (arr.length == 0) {
            return null;
        }
        // 求1号顶点到各顶点的距离
        // 存储1号顶点到各顶点的初始距离
        int[] dis = new int[10];
        for (int j = 1; j <= n; j++) {
            dis[j] = arr[i][j];
        }
        return dis;
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
        for (int i = 1; i <= n; i++) {
            System.out.println(i + ":" + e[i]);
        }
    }
}
