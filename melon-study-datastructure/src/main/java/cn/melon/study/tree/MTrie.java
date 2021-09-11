package cn.melon.study.tree;

/**
 * 我的实现
 *
 * @author imelonkid
 * @date 2021/09/11 16:04
 **/
public class MTrie {

    private MTrieNode root = new MTrieNode();

    public void insert(String s) {
        MTrieNode currNode = root;

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            MTrieNode trieNode = currNode.getNext()[idx];
            if (trieNode == null) {
                trieNode = new MTrieNode(s.charAt(i));
                if (i == s.length() - 1) {
                    trieNode.setWord(true);
                }
                currNode.getNext()[idx] = trieNode;
                currNode = trieNode;
                continue;
            }

            trieNode.setWord(true);
        }
    }

    public boolean search(String s) {
        MTrieNode currNode = root;

        MTrieNode trieNode = null;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            trieNode = currNode.getNext()[idx];
            if (trieNode == null) {
                return false;
            }
            currNode = trieNode;
        }

        return trieNode != null && trieNode.isWord();
    }


    public boolean isPrefix(String s) {
        MTrieNode currNode = root;

        MTrieNode trieNode = null;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            trieNode = currNode.getNext()[idx];
            if (trieNode == null) {
                return false;
            }
            currNode = trieNode;
        }

        return true;
    }

    public static void main(String[] args) {
        MTrie trie = new MTrie();
        trie.insert("apple");
        trie.insert("app");
        boolean a = trie.search("apple");
        boolean b = trie.isPrefix("ap");
        System.out.println(a + " " + b);
    }
}
