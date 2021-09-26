package cn.melon.study.tree;

/**
 * @author imelonkid
 * @date 2021/09/22 11:24
 **/
public class Node {

    private int val;


    private Node left;


    private Node right;


    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
