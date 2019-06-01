package map;

/**
 * 图
 *
 * @author Mengjun Wen
 * @date 2018/9/30
 */
public class Map {

    /**
     * 顶点数组
     */
    private Vertex[] vertices;

    /**
     * 邻接矩阵
     */
    private int[][] adjMat;

    /**
     * 顶点最大数
     */
    private int maxSize;

    /**
     * 当前顶点
     */
    private int nVertex;

    public Map(int maxSize) {
        this.maxSize = maxSize;
        vertices = new Vertex[maxSize];
        adjMat = new int[maxSize][maxSize];
        nVertex = 0;
        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < maxSize; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    /**
     * 插入顶点
     * @param value 插入顶点的值
     */
    public void insertVertex(char value) {
        Vertex vertex = new Vertex(value);
        vertices[nVertex++] = vertex;
    }

    /**
     * 插入邻接
     * @param start 起始顶点
     * @param end 结束顶点
     */
    public void insertAdj(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }
}
