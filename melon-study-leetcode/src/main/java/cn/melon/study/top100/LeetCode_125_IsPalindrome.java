package cn.melon.study.top100;

/**
 * 验证字符串是回文字符串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * @author imelonkid
 * @date 2021/09/08 23:14
 **/
public class LeetCode_125_IsPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String s1 = ",,";
        String s2 = "0P";
        LeetCode_125_IsPalindrome isPalindrome = new LeetCode_125_IsPalindrome();
        boolean yes = isPalindrome.isPalindromeStr(s2, 0, s2.length() - 1);
        System.out.println(yes);
    }

    /**
     * 判断窗口是否是回文字符串
     * 核心思路：定义两个指针，一个指向字符串的起始区间，一个指向字符串的截止区间
     * 从字符串两头寻找有效字符，找到就进行比较
     * 如果字符串长度是奇数个，那么循环在i == j处结束
     * 如果字符串长度是偶数个，那循环在i > j处结束
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
                return false;
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
