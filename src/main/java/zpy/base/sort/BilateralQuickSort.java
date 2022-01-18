package zpy.base.sort;

import zpy.base.utils.Util;

import java.util.Arrays;

/**
 * 双边循环快排
 *
 * @author zpy
 * @since 2022/01/10 15:18
 */
public class BilateralQuickSort {

    public static void main(String[] args) {
        int[] a = {5, 3, 7, 2, 9, 8, 1, 4};
        System.out.println(Arrays.toString(a));
        quickSort(a, 0, a.length - 1);
    }

    /**
     * 递归实现双边循环快排
     *
     * @param a 待排序数组
     * @param l 左边界
     * @param r 右边界
     * @author zpy
     * @since 2022/1/10 15:20
     **/
    private static void quickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(a, l, r);
        quickSort(a, l, p - 1);
        quickSort(a, p + 1, r);
    }

    /**
     * 霍尔分区实现
     *
     * @param a 待排序数组
     * @param l 左边界
     * @param r 右边界
     * @return {@link int}
     * @author zpy
     * @since 2022/1/10 15:22
     **/
    private static int partition(int[] a, int l, int r) {
        // 选取最左侧元素作为基准点
        int pv = a[l];
        // i 从左向右搜索比基准点元素大的元素
        int i = l;
        // j 从右向左搜索比基准点元素小的元素
        int j = r;

        while (i < j) {
            // 从右向左搜索比基准点元素小的元素
            while (i < j && a[j] > pv) {
                j--;
            }
            // i 从左向右搜索比基准点元素大的元素
            while (i < j && a[i] <= pv) {
                i++;
            }
            Util.swap(a, i, j);
        }
        // 分区结束，与基准点元素进行交换
        Util.swap(a, i, l);
        System.out.println(Arrays.toString(a));
        return i;
    }


}
