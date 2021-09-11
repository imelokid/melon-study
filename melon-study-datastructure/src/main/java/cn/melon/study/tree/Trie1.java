package cn.melon.study.tree;

/**
 * Trie
 *
 * @author imelonkid
 * @date 2021/09/11 10:00
 **/
public class Trie1 {

    int N = 100009; // 直接设置为十万级
    int[][] trie;
    int[] count;
    int index;

    public Trie1() {
        trie = new int[N][26];
        count = new int[N];
        index = 0;
    }

    public void insert(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0) {
                trie[p][u] = ++index;
            }
            p = trie[p][u];
        }
        count[p]++;
    }

    public boolean search(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0) {
                return false;
            }
            p = trie[p][u];
        }
        return count[p] != 0;
    }

    public boolean startsWith(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0) {
                return false;
            }
            p = trie[p][u];
        }
        return true;
    }


    public static void main(String[] args) {
        Trie1 trie = new Trie1();
        trie.insert("a");
        trie.insert("a");
        trie.search("le");
    }
}
