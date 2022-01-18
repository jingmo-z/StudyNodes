package zpy.base.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author zpy
 * @since 2021/12/24 15:42
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] a = {3, 4, 6, 1, 7, 8, 2, 5};
        insert(a);
    }

    /**
     * 插入排序
     *
     * @param a 数组
     * @author zpy
     * @since 2021/12/24 15:43
     **/
    public static void insert(int[] a) {
        // i代表待插入元素的索引
        for (int i = 1; i < a.length; i++) {
            // 待插入的元素值
            int t = a[i];
            // 已排序区域的元素索引
            int j = i - 1;
            while (j >= 0) {
                if (t < a[j]) {
                    a[j + 1] = a[j];
                } else {
                    // 退出循环减少循环次数
                    break;
                }
                j--;
            }
            a[j + 1] = t;
            System.out.println("第" + i + "轮插入：" + Arrays.toString(a));
        }
    }
}
