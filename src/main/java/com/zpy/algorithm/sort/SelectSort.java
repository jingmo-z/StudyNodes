package com.zpy.algorithm.sort;

import java.util.Arrays;

/**
 * @author zpy
 * @since 2021/12/10
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] a = {3, 4, 6, 1, 7, 8, 2, 5};
        selection(a);
    }

    private static void selection(int[] a) {
        System.out.println("第0轮选择：" + Arrays.toString(a));
        for (int i = 0; i < a.length - 1; i++) {
            // i 代表每轮选择最小元素需要存放的索引
            int s = i;
            // s 代表最小元素的索引
            for (int j = i + 1; j < a.length; j++) {
                if (a[s] > a[j]) {
                    s = j;
                }
            }
            // 交换索引
            Util.swap(a, i, s);
            System.out.println("第" + (i + 1) + "轮选择：" + Arrays.toString(a));
        }

    }

}
