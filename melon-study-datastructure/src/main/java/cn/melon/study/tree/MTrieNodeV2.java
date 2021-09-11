package cn.melon.study.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 我的实现
 *
 * @author imelonkid
 * @date 2021/09/11 16:04
 **/
public class MTrieNodeV2 {

    public Character val;

    /** 是否是单词 */
    public boolean isWord;

    public Map<Character, MTrieNodeV2> next = new HashMap<>();

    public MTrieNodeV2() {
    }

    public MTrieNodeV2(Character val) {
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

}
