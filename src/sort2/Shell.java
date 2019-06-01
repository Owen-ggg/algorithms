package sort2;


import java.util.Arrays;

/**
 * 希尔排序
 * @author Mengjun Wen
 * @date 2018/6/8
 */
public class Shell {

    public static void main(String[] args) {
        int[] a = {1, 5, 3, 2, 6, 4, 8, 0};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a){
        int length = a.length;
        int h = 1;
        while(h<length/3){
            h=h*3+1;
        }

        while(h>=1){
            for (int i = h; i < length; i++) {
                for (int j = i; j >=h && a[j]<a[j-h]; j-=h) {
                    int temp = a[j];
                    a[j]=a[j-h];
                    a[j-h]=temp;
                }
            }
            h=h/3;
        }
    }

}
