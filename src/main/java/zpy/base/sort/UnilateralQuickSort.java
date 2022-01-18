package zpy.base.sort;

import zpy.base.utils.Util;

import java.util.Arrays;

/**
 * 单边循环快排
 *
 * @author zpy
 * @since 2022/01/09 19:46
 */
public class UnilateralQuickSort {

    public static void main(String[] args) {
        int[] a = {5, 3, 7, 2, 9, 8, 1, 4};
        quickSort(a, 0, a.length - 1);
    }

    /**
     * 递归完成单边快排
     *
     * @param a 待排序的数组
     * @param l 左边界
     * @param r 右边界
     * @author zpy
     * @since 2022/1/9 20:00
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
     * 进行一次分区操作
     *
     * @param a 待排序的数组
     * @param l 左边界
     * @param r 右边界
     * @return {@link int} 本次分区完成的基准点的索引
     * @author zpy
     * @since 2022/1/9 19:54
     **/
    private static int partition(int[] a, int l, int r) {
        // 基准点元素
        int pv = a[r];
        int i = l;
        for (int j = l; j < r; j++) {
            // 找到比基准点元素小的值时交换 i 和 j 索引的值
            if (a[j] < pv) {
                Util.swap(a, i, j);
                i++;
            }
        }
        // 将基准点元素交换到索引为 i 的位置
        Util.swap(a, i, r);
        System.out.println(Arrays.toString(a) + " , i = " + i);

        return i;
    }
}
