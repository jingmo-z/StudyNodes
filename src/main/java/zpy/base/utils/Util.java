package zpy.base.utils;

/**
 * @author zpy
 * @since 2021/12/10
 */
public class Util {

    /**
     * 交换数组中两个索引的值
     *
     * @param a 数组
     * @param i 索引1
     * @param j 索引2
     * @author zpy
     * @since 2021/12/24 15:11
     **/
    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
