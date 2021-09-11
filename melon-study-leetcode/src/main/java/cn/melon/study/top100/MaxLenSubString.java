package cn.melon.study.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 无重复最长子字符串
 *
 * @author imelonkid
 * @date 2021/09/07 19:17
 **/
public class MaxLenSubString {

    public static void main(String[] args) {
        MaxLenSubString subString = new MaxLenSubString();
        int a = subString.lengthOfLongestSubstring("ddd");
        System.out.println(a);
    }

    /**
     * 通过滑动窗口寻找子串
     * 核心思路：在字符数组上设置两个指针，初始时，左右指针指向数组元素的第一个位置
     * 之后边开始滑动右指针，将新字符加入到滑动窗口。
     * 对新加入的元素做check，如果元素在之前的数组中不存在重复，则直接加入并继续右移
     * 右指针，否则右移左指针，移动到窗口内与刚加入元素重复元素后面的第一个元素
     */
    public int lengthOfLongestSubstring(String s) {

        // 左边界指针
        int i = 0;
        int j = i;
        int maxLen = 0;

        // 右边界指针
        for (; j < s.length(); j++) {
            if (i == j) {
                // 窗口大小为1 两个指针指向同一个元素，啥也不做，等待
                // 右边界j右滑，获取新的校验元素
                continue;
            }

            //窗口[i, j) 这里不不含j，因为这个j现在还没有真正进入窗口
            //在进入窗口之前，需要先对其做一个重复校验
            for (int k = i; k < j; k++) {
                if (s.charAt(k) == s.charAt(j)) {
                    // 出现重复，需要调整窗口。不过在调整之前，需要更新最长子串长度
                    // 因为窗口调整前和调整后是两个不同的子串
                    // 注意这里是j - i，因为j元素目前还是校验元素，并没有真正在窗口中
                    maxLen = Math.max(maxLen, j - i);

                    // 出现重复，这时需要调整窗口；调整方法是：将窗口左边界移动到窗口中
                    // 与校验元素重复的元素后一个位置。当前窗口中的重复元素位置为k
                    i = k + 1;
                    break;
                }

            }
        }
        return Math.max(maxLen, j - i);
    }


    private int lengthOfLongestSubstring2(String s) {
        // 保存所有可能的子字符串
        List<String> subStrs = new ArrayList<>();

        // 获得所有子串
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                subStrs.add(s.substring(i, j + 1));
            }
        }

        int maxLen = 0;

        // 检查每个子串，并得到最长无重复子串
        for (String subStr : subStrs) {
            // 是否有重复KEY
            boolean flag = false;

            // 字典
            Map<Character, Integer> hash = new HashMap<>();
            for (int i = 0; i < subStr.length(); i++) {
                if (hash.containsKey(subStr.charAt(i))) {
                    flag = true;
                    break;
                }

                hash.put(subStr.charAt(i), i);
            }

            if (flag) {
                // 有重复KEY 舍弃
                continue;
            }

            // 符合要求的字符串
            maxLen = Math.max(maxLen, subStr.length());
        }

        return maxLen;

    }
}
