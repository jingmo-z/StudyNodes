package com.zpy.algorithm;

/**
 * @author zpy
 */
public class HalfSearch {

    public static void main(String[] args) {
        int[] array = {1, 5, 8, 11, 19, 22, 31, 35, 40, 45, 48, 49, 50};
        int target = 48;
        int index = halfSearch(array, target);
        System.out.println(index);
    }

    private static int halfSearch(int[] a, int target) {
        int l = 0, r = a.length, m;
        while (l <= r) {
            // 如果 l+r 超出int的范围，运算结果将为负数
            m = (l + r) / 2;
            // 解决方案 1：(l+r)/2  ==>  l-l/2+r/2  ==>  l+(r/2-l/2)  ==>   l+(r-l)/2
            m = l + (r - l) / 2;
            // 解决方案 2：使用位运算
            m = (l + r) >>> 1;
            if (a[m] == target) {
                return m;
            } else if (a[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

}
