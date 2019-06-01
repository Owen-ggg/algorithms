package tree;

/**
 * 二叉树
 *
 * @author Mengjun Wen
 * @date 2018/9/27
 */
public class Tree<T extends Comparable> {
    /**
     * 根节点
     */
    public Node<T> root;


    /**
     * 新增节点
     *
     * @param data 数据
     */
    public void insert(T data) {
        Node newNode = new Node(data);
        Node current = root;
        Node parent;
        if (root == null) {
            root = newNode;
            return;
        } else {
            while (true) {
                parent = current;
                if (current.getData().compareTo(data) > 0) {
                    current = current.getLeftChild();
                    if (null == current) {
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else {
                    current = current.getRightChild();
                    if (null == current) {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    /**
     * 查找节点
     *
     * @param data 节点数据
     * @return 找到的节点 没找到返回null
     */
    public Node find(T data) {
        Node current = root;
        while (null != current && current.getData().compareTo(data) != 0) {
            if (current.getData().compareTo(data) > 0) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }
        return current;
    }


    /**
     * 前序遍历
     *
     * @param localNode 遍历的初始节点
     */
    public void frontOrder(Node localNode) {
        if (null != localNode) {
            System.out.println(localNode.getData());
            frontOrder(localNode.getLeftChild());
            frontOrder(localNode.getRightChild());
        }
    }

    /**
     * 中序遍历
     *
     * @param localNode 遍历的初始节点
     */
    public void interOrder(Node localNode) {
        if (null != localNode) {
            interOrder(localNode.getLeftChild());
            System.out.println(localNode.getData());
            interOrder(localNode.getRightChild());
        }
    }

    public boolean delete(Node removeNode) {
        Comparable data = removeNode.getData();
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (null != current && current.getData().compareTo(data) != 0) {
            parent = current;
            if (current.getData().compareTo(data) > 0) {
                current = current.getLeftChild();
                isLeftChild = true;
            } else {
                current = current.getRightChild();
                isLeftChild = false;
            }
            if (current == null) {
                return false;
            }
        }
        // 删除叶子节点
        if (null == current.getLeftChild() && null == current.getRightChild()) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
        } else if (current.getRightChild() == null) {
            if (current == root) {
                root = current.getLeftChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
        } else if (current.getLeftChild() == null) {
            if (current == root) {
                root = current.getRightChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getRightChild());
            } else {
                parent.setRightChild(current.getRightChild());
            }
        } else {
            // 查找到中序后继
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;

            } else if (isLeftChild) {
                parent.setLeftChild(successor);
            } else {
                parent.setRightChild(successor);
            }
            successor.setLeftChild(current.getLeftChild());
        }
        return true;
    }

    /**
     * 获取后续节点
     *
     * @param current 当前节点
     * @return 后续节点
     */
    private Node getSuccessor(Node current) {
        Node parent = current;
        Node successor = parent.getRightChild();
        while (null != successor.getLeftChild()) {
            parent = successor;
            successor = successor.getLeftChild();
        }
        if (successor != current.getRightChild()) {
            parent.setLeftChild(successor.getRightChild());
            successor.setRightChild(current.getRightChild());
        }
        return successor;
    }
}

class Test {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree();
        tree.insert(3);
        tree.insert(6);
        tree.insert(2);
        tree.insert(2);
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.insert(5);
        tree.delete(tree.find(5));
        tree.interOrder(tree.root);
    }
}
