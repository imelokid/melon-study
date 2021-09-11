package cn.melon.study.tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 我的实现
 *
 * @author imelonkid
 * @date 2021/09/11 16:04
 **/
public class MTrieV2 {

    private MTrieNodeV2 root = new MTrieNodeV2();

    public void insert(String s) {
        MTrieNodeV2 currNode = root;
        MTrieNodeV2 trieNode = null;

        for (int i = 0; i < s.length(); i++) {
            trieNode = currNode.next.get(s.charAt(i));
            if (trieNode == null) {
                trieNode = new MTrieNodeV2(s.charAt(i));
                currNode.next.put(s.charAt(i), trieNode);
            }

            currNode = trieNode;
        }

        currNode.setWord(true);
    }

    public boolean search(String s) {
        MTrieNodeV2 currNode = root;

        MTrieNodeV2 trieNode = null;
        for (int i = 0; i < s.length(); i++) {
            trieNode = currNode.next.get(s.charAt(i));
            if (trieNode == null) {
                return false;
            }
            currNode = trieNode;
        }

        return trieNode != null && trieNode.isWord();
    }


    public boolean isPrefix(String s) {
        MTrieNodeV2 currNode = root;

        MTrieNodeV2 trieNode = null;
        for (int i = 0; i < s.length(); i++) {
            trieNode = currNode.next.get(s.charAt(i));
            if (trieNode == null) {
                return false;
            }
            currNode = trieNode;
        }

        return true;
    }

    /**
     * 推荐
     * @param s
     * @return
     */
    public List<StringBuilder> recommend(String s) {
        MTrieNodeV2 currNode = root;

        MTrieNodeV2 trieNode = null;
        for (int i = 0; i < s.length(); i++) {
            trieNode = currNode.next.get(s.charAt(i));
            if (trieNode == null) {
                return new ArrayList<>();
            }
            currNode = trieNode;
        }

        List<StringBuilder> sbs = new ArrayList<>();
        tracer(currNode, false, new StringBuilder(), s, sbs);

        return sbs;
    }

    private void tracer(MTrieNodeV2 currNode, boolean isStart, StringBuilder sb,String prefix, List<StringBuilder> sbs) {
        if(currNode.isWord && currNode.next.values().size() == 0) {
            StringBuilder sb1 = new StringBuilder(sb);
            sb1.append(currNode.val);
            sbs.add(new StringBuilder(prefix).append(sb1));
            sb.delete(0, sb.length());
            return;
        }
        if(currNode.isWord) {
            StringBuilder sb1 = new StringBuilder(sb);
            sb1.append(currNode.val);
            sbs.add(new StringBuilder(prefix).append(sb1));
            sb.delete(0, sb.length());
        }else{
            if(isStart) {
                sb.append(currNode.val);
            }
        }

        if(currNode.next.values().size() == 0) {
            sb.append(currNode.val);
            sbs.add(new StringBuilder(prefix).append(sb));
            sb.delete(0, sb.length());
            return;
        }
        for(MTrieNodeV2 node : currNode.next.values()) {
            tracer(node, true, sb, prefix, sbs);
        }
    }


    public static void main(String[] args) throws IOException {
        MTrieV2 trie = new MTrieV2();
        InputStream f = trie.getClass().getClassLoader().getResourceAsStream("data.txt");
        BufferedReader bf = new BufferedReader(new InputStreamReader(f));
        String line = "";
        while((line = bf.readLine()) != null) {
            String name = line.split("\t")[0];
            System.out.println(name);
            trie.insert(name);
        }
        Scanner scan = new Scanner(System.in);
        // 判断是否还有输入
        while (scan.hasNext()) {
            String str1 = scan.next();
            List<StringBuilder> sbs = trie.recommend(str1);
            for(int i = 0; i < sbs.size(); i++) {
                System.out.println(sbs.get(i).toString());
            }
        }
    }
}
