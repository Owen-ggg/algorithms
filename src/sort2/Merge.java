package sort2;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author Mengjun Wen
 * @date 2018/6/26
 */
public class Merge {

    public static void main(String[] args) {
        int[] a = {1, 4, 7, 2, 3, 4};
        aux = new int[a.length];
//        merge(a, 0, 2, a.length - 1);
        sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    private static int[] aux;

    /**
     * 原地归并排序
     *
     * @param a   需要排序的数组
     * @param lo  最小索引
     * @param mid 中间索引
     * @param hi  最大索引
     */
    public static void merge(int[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        // copy a to aux
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            // 左边取完取右边
            if (i > mid) {
                a[k] = aux[j++];
                // 右边取完取左边
            } else if (j > hi) {
                a[k] = aux[i++];
                // 哪边小取哪边
            } else if (less(aux[i], aux[j])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }


    /**
     * 自顶而下的归并排序
     * @param a 数组
     * @param lo 开始索引
     * @param hi 终止索引
     */
    public static void sort(int[] a,int lo,int hi){
        if(hi<=lo){
            return;
        }
        int mid = lo+(hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    /**
     * 比较ab大小
     *
     * @param a 参数
     * @param b 参数
     * @return boolean
     */
    public static boolean less(int a, int b) {
        return a < b;
    }
}
