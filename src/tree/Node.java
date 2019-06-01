package tree;

/**
 * 二叉树节点类
 * @author Mengjun Wen
 * @date 2018/9/27
 */
public class Node<T extends Comparable>{

    /**
     * 数据
     */
    private T data;

    /**
     * 左子节点
     */
    private Node leftChild;

    /**
     * 右子节点
     */
    private Node rightChild;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
