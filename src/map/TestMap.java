package map;

/**
 * 图的测试
 *
 * @author Mengjun Wen
 * @date 2018/9/30
 */
public class TestMap {
    public static void main(String[] args) {
        Map map = new Map(5);
        map.insertVertex('a');
        map.insertVertex('b');
        map.insertVertex('c');
        map.insertVertex('d');
        map.insertAdj(0, 1);
        map.insertAdj(1, 2);
        map.insertAdj(2, 3);
        System.out.println(map);
    }
}
