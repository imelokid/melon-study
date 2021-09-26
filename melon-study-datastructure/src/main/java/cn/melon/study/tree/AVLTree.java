package cn.melon.study.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Avl树
 * 判定一棵树是否为AVL树？AVL树的定义是，
 * 任选树的一个节点为根节点，其左右子树高度之差不大于1，且这个树为一颗排序树
 *
 * @author imelonkid
 * @date 2021/09/22 11:23
 **/
public class AVLTree {

    public static void main(String[] args) {
        System.out.println(3%7);
    }

    public boolean checkAvlTree(Node root) {
        return isBST(root) && isBalance(root);
    }

    /**
     * 判断给定树是否是平衡树
     * 特点：所有子树的高度差不能大于1
     * @param root
     * @return
     */
    private boolean isBalance(Node root) {
        if(root == null) {
            return true;
        }

        if(!isBalance(root.getLeft()) || !isBalance(root.getRight())) {
            return false;
        }

        int lhight = caculateHight(root.getLeft()) + 1;
        int rhight = caculateHight(root.getRight()) + 1;
        return Math.abs(lhight - rhight) <= 1;
    }

    private int caculateHight(Node node) {
        if(node == null) {
            return 0;
        }

        int lhight = caculateHight(node.getLeft()) + 1;
        int rhight = caculateHight(node.getRight()) + 1;
        return Math.max(lhight, rhight) ;
    }

    /**
     * 判断给定树是否是二分搜索树
     * 特点:所有子树的值要满足 根节点大于左节点，更节点小于又节点
     * @param root
     * @return
     */
    private boolean isBST(Node root) {
        if(root == null) {
            return true;
        }

        // 递归走下游子树
        if(!isBST(root.getLeft()) || !isBST(root.getRight())) {
            return false;
        }

        Node lnode = root.getLeft();
        if(lnode != null && lnode.getVal() > root.getVal()) {
            return false;
        }

        Node rnode = root.getRight();
        if(rnode != null && rnode.getVal() < root.getVal()) {
            return false;
        }

        return true;
    }


}
