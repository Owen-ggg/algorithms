package map;

/**
 * 顶点
 * @author Mengjun Wen
 * @date 2018/9/30
 */
public class Vertex {

    /**
     * 顶点名称
     */
    private char lable;

    public Vertex(char lable) {
        this.lable = lable;
    }

    public char getLable() {
        return lable;
    }

    public void setLable(char lable) {
        this.lable = lable;
    }
}
