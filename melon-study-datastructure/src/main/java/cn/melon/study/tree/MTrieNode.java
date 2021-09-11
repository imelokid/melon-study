package cn.melon.study.tree;

/**
 * 我的实现
 *
 * @author imelonkid
 * @date 2021/09/11 16:04
 **/
public class MTrieNode {

    private Character val;

    /** 是否是单词 */
    private boolean isWord;

    /**下游指针 */
    private MTrieNode[] next = new MTrieNode[26];

    public MTrieNode() {
    }

    public MTrieNode(Character val) {
        this.val = val;
    }

    public Character getVal() {
        return val;
    }

    public void setVal(Character val) {
        this.val = val;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }

    public MTrieNode[] getNext() {
        return next;
    }

    public void setNext(MTrieNode[] next) {
        this.next = next;
    }
}
