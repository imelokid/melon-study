package cn.melon.study;

import cn.melon.study.comm.TreeNode;
import cn.melon.study.top100.ListNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 层级打印
 *
 * @author imelonkid
 * @date 2021/09/25 13:28
 **/
public class LeetCode_102_PrintTreeLeve {

    public List<List<Integer>> levelOrder1(TreeNode root){
        List<List<Integer>> ret = new ArrayList<>();
        Map<Integer, List<Integer>> datas = new HashMap<>();
        tracerTree(root, datas, 1);
        for(List<Integer> val : datas.values()) {
            ret.add(val);
        }
        System.out.println(ret);
        return ret;
    }


    private void tracerTree(TreeNode root, Map<Integer, List<Integer>> hash, int i) {
        if(root == null) {
            return;
        }
        List<Integer> nodeArr = hash.get(i);
        if(nodeArr == null) {
            nodeArr = new ArrayList<>();
            nodeArr.add(root.val);
            hash.put(i, nodeArr);
        }else{
            nodeArr.add(root.val);
        }

        tracerTree(root.left, hash, i + 1);
        tracerTree(root.right, hash, i + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        List<List<Integer>> levelVals = new ArrayList<>();

        while (!nodes.isEmpty()) {
            List<Integer> vals = new ArrayList<>();
            levelVals.add(vals);

            int currSize = nodes.size();
            for (int i = 0; i < currSize; i++) {
                TreeNode currNode = nodes.poll();
                vals.add(currNode.val);
                if (currNode.left != null) {
                    nodes.add(currNode.left);
                }
                if (currNode.right != null) {
                    nodes.add(currNode.right);
                }
            }
        }

        return levelVals;
    }
}
