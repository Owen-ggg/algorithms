package recursive;

/**
 * 汉诺塔
 *
 * @author Mengjun Wen
 * @date 2018/9/25
 */
public class HanoiTower {

    static int count=0;

    public static void main(String[] args) {
        doTower(20,'A','B','C');
        System.out.println(count);
    }

    public static void doTower(int topN, char from, char inter, char to) {
        count++;
        if (topN == 1) {
            System.out.println("盘子" + topN + "从" + from + "移动到" + to);
        }else {
            doTower(topN-1,from,to,inter);
            System.out.println("盘子" + topN + "从" + from + "移动到" + to);
            doTower(topN-1,inter,from,to);
        }
    }
}
