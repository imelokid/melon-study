package cn.melon.study;

import cn.melon.study.comm.TreeNode;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/
 */
public class LeetCode_114_Tree2List {

    public static void main(String[] args) {
        LeetCode_114_Tree2List leetCode114Tree2List = new LeetCode_114_Tree2List();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(5);
        TreeNode leftLeft = new TreeNode(3);
        TreeNode leftRight = new TreeNode(4);
        TreeNode rightRight = new TreeNode(6);

        root.left = left;
        root.right = right;
        left.left = leftLeft;
        left.right = leftRight;
        right.right = rightRight;

        leetCode114Tree2List.flatten(root);
        System.out.println(root);
    }

    public void flatten(TreeNode root) {
        flattenBySplit(root);
    }

    /**
     思路2：
     问题拆分，将整体问题拆分为多个子问题
     本题是思路是，以二叉树中的某一个节点为子树，
     那么如果他是叶子节点，啥也不做
     如果他是非叶子节点，需要将其右子树拼接到左子树的右子树上
     */
    private TreeNode flattenBySplit(TreeNode root){
        if(root == null) {
            return null;
        }

        TreeNode leftFlattenNode = flattenBySplit(root.left);
        TreeNode rightFlattenNode = flattenBySplit(root.right);

        System.out.println("left->"+ printNode(leftFlattenNode)
                +" right->" + printNode(rightFlattenNode) + " node->" +printNode(root));

        // 拼接
        if(leftFlattenNode != null) {
            findLastNode(leftFlattenNode).right = rightFlattenNode;
            root.right = leftFlattenNode;
            root.left = null;
        }

        return root;
    }

    private TreeNode findLastNode(TreeNode node) {
        if(node == null) {
            return null;
        }

        if(node.right == null) {
            return node;
        }

        return findLastNode(node.right);
    }

    private String printNode(TreeNode node) {
        if(node == null) {
            return "null";
        }

        return node.val + "";
    }

}
