package com.zpy.algorithm.sort;

/**
 * @author zpy
 * @since 2021/12/10
 */
public class Util {

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
