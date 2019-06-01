package sort2;

/**
 * @author Mengjun Wen
 * @date 2018/9/25
 */
public class InsertSort {

    public static void main(String[] args) {
        long[] arr = new long[]{1,8,5,3};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void sort(long[] arr){

        long temp = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >0 ; j--) {
                if(arr[j-1] > arr[j]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
