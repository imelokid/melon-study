package cn.melon.study.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * TrieNode
 *
 * @author imelonkid
 * @date 2021/09/10 21:00
 **/
public class TrieNode {

    // 子节点(key是下级字符，value是下级节点)
    private Map<Character, TrieNode> subNodes = new HashMap<>();

    // 添加子节点
    public void addSubNode(Character c, TrieNode subNode) {
        subNodes.put(c, subNode);
    }

    // 获取子节点
    public TrieNode getSubNode(Character c) {
        return subNodes.get(c);
    }
}
