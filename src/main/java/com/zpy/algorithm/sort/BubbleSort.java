package com.zpy.algorithm.sort;

import com.zpy.algorithm.utils.Util;

import java.util.Arrays;

/**
 * @author zpy
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {5, 3, 7, 4, 1, 2, 8, 9};
        //int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        bubble(a);
        System.out.println("------------------");
        a = new int[]{5, 3, 7, 4, 1, 2, 8, 9};
        bubbleLevel(a);
    }

    /**
     * 冒泡排序--优化
     *
     * @param a 数组
     * @author zpy
     * @since 2021/12/24 15:16
     **/
    private static void bubbleLevel(int[] a) {
        int n = a.length - 1;
        int count = 0;
        while (true) {
            int last = 0;
            // 控制交换次数
            for (int j = 0; j < n; j++) {
                System.out.println("比较第" + (j + 1) + "次");
                count++;
                if (a[j] > a[j + 1]) {
                    Util.swap(a, j, j + 1);
                    // 每次交换都记录下交换的索引
                    last = j;
                }
            }
            n = last;
            System.out.println("第次交换：" + Arrays.toString(a));
            // 当上一轮冒泡最后交换的值的索引是0时，代表数组有序。
            if (n == 0) {
                break;
            }
        }
        System.out.println("优化算法一共交换了" + count + "次");
    }

    /**
     * 冒泡排序
     *
     * @param a 数组
     * @author zpy
     * @since 2021/12/24 15:16
     **/
    private static void bubble(int[] a) {
        int count = 0;
        // 基本的冒泡排序
        // 控制冒泡次数
        for (int i = 0; i < a.length - 1; i++) {
            // 控制交换次数
            boolean flag = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                count++;
                System.out.println("比较第" + (j + 1) + "次");
                if (a[j] > a[j + 1]) {
                    Util.swap(a, j, j + 1);
                    flag = true;
                }
            }
            System.out.println("第" + (i + 1) + "次交换：" + Arrays.toString(a));
            if (!flag) {
                // 当冒泡一次比较都没有成立时代表数组已经时有序的
                break;
            }
        }
        System.out.println("基本算法一共交换了" + count + "次");
    }


}
