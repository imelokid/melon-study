package cn.melon.study.top100;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * @author imelonkid
 * @date 2021/09/08 23:14
 **/
public class LeetCode_5_longestPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String s1 = ",,";
        String s2 = "0P";
        LeetCode_5_longestPalindrome longestPalindrome = new LeetCode_5_longestPalindrome();
        String yes = longestPalindrome.longestPalindrome(s2);
        System.out.println(yes);
    }

    /**
     * 双层循环，外层循环指向字符串首位
     * 内层循环指向后面的字符，不停收缩窗口完成对回文子字符串的搜索
     */
    public String longestPalindrome(String s) {
        String finalStr = "";
        for(int i = 0; i < s.length() - 1; i++) {
            for(int j = i + 1; j < s.length(); j++) {
                if(isPalindromeStr(s, i, j)) {
                    if(j - i + 1 > finalStr.length()) {
                        finalStr = s.substring(i , j + 1);
                    }
                }
            }
        }

        return finalStr;
    }


    /**
     * 判断窗口是否是回文字符串
     */
    private boolean isPalindromeStr(String s, int i, int j) {
        // 从左到右获取合法比较字符
        // 奇数情况下会出现i == j 偶数情况下会出现 i > j
        // 无论是奇数还是偶数，这个判断都可以覆盖
        while (i < j) {
            // 从左向右扫描合法字符
            Character left = null;
            Character right = null;
            while ((i <= j) && (left = validChar(s.charAt(i))) == null) {
                i++;
            }

            while ((i <= j) && (right = validChar(s.charAt(j))) == null) {
                j--;
            }

            // 唯一的可能是 字符串全部都是非法字符
            if(left == null) {
                return true;
            }

            if (!left.equals(right)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }


    private Character validChar(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + 32);
        }

        if (c >= 'a' && c <= 'z') {
            return c;
        }

        if (48<= c && c <= 57) {
            return c;
        }

        return null;
    }


}
