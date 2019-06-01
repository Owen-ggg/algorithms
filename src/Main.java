
public class Main {

    public static void main(String[] args) {
        int[] ints = SelectionSort.selectionSort(new int[]{1, 5, 3, 9, 2, 4});
        println(ints);
    }

    public static void println(int[] arrs){
        for (int i = 0; i < arrs.length; i++) {
            System.out.print(arrs[i]+" ");
        }
    }


}
