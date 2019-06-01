package array;

/**
 * @author Mengjun Wen
 * @date 2018/9/24
 */
public class MyOrderArray {

    /**
     * 数组
     */
    private long[] arr;

    /**
     * 有效个数
     */
    private int elements;

    public MyOrderArray() {
        arr = new long[8];
    }

    public MyOrderArray(int maxSize) {
        arr = new long[maxSize];
    }

    public void insert(long value) {
        int i;
        for (i = 0; i < elements; i++) {
            if (arr[i] > value) {
                break;
            }
        }
        for (int j = elements; j > i; j--) {
            arr[j] = arr[j - 1];
        }
        arr[i] = value;
        elements++;
    }

    public void display() {
        for (int i = 0; i < elements; i++) {
            System.out.println(arr[i]);
        }
    }

    public int binarySearch(long value) {
        int mid;
        int low = 0;
        int pow = elements;
        while (true) {
            mid = (low + pow) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (low > pow) {
                return -1;
            } else {
                if (arr[mid] > value) {
                    pow = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
    }
}

class Test {

    public static void main(String[] args) {
        MyOrderArray myOrderArray = new MyOrderArray();
        myOrderArray.insert(3);
        myOrderArray.insert(2);
        myOrderArray.insert(25);
        myOrderArray.insert(7);
        myOrderArray.display();
        System.out.println("binary search index is : " + myOrderArray.binarySearch(2));
    }
}
