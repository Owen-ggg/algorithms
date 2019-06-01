import java.util.LinkedList;

/**
 * 约瑟夫环问题
 *
 * @author Mengjun Wen
 * @date 2018/6/4
 */
public class Josephus {

    public static void main(String[] args) {
        josepusONWithList(7, 4);
    }

    public static int josepusONWithList(int n, int m) {
        return josepusONWithList(n, m, 1);
    }

    public static int josepusONWithList(int n, int m, int k) {
        if (n <= 0 || m <= 0 || k <= 0) {
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int outPos;
        while (list.size() > 1) {
            outPos = ((k - 1) + (m - 1)) % list.size();
            System.out.print(list.get(outPos) + " , ");
            list.remove(outPos);
            k = outPos + 1;
        }
        System.out.println(list.get(0));
        return list.get(0);
    }
}
