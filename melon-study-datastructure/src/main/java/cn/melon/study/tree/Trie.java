package cn.melon.study.tree;

/**
 * Trie
 *
 * @author imelonkid
 * @date 2021/09/10 21:00
 **/
public class Trie {

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curNode = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode subNode = curNode.getSubNode(c);

            // 如果没有这个节点则新建
            if (subNode == null) {
                subNode = new TrieNode();
                curNode.addSubNode(c, subNode);
            }
            // 指向子节点，进入下一循环
            curNode = subNode;
        }
        // 设置结束标识
        curNode.addSubNode('#', new TrieNode());
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curNode = this.root;
        for (int i = 0; i < word.length(); i++) {
            curNode = curNode.getSubNode(word.charAt(i));
            if (curNode == null) {
                return false;
            }
        }
        return curNode.getSubNode('#') != null;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curNode = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            curNode = curNode.getSubNode(prefix.charAt(i));
            if (curNode == null) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
        boolean b = t.search("app");
        System.out.println(b);
    }
}
