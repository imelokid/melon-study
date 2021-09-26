package cn.melon.study;

/**
 * 数组滚动 空间复杂度降到O(1)
 * 给定输入数组与数字K，将数组从左向右整体位移K次，输出位移后的结果
 * <p>
 * 输入：  4,5,6,7,1,2,3  4
 * 输出： 4,5,6,7,1,2,3
 *
 * @author imelonkid
 * @date 2021/09/22 11:45
 **/
public class ScrollArr {

    public int[] solution(int[] arr, int k) {
        int maxIdx = arr.length - 1;

        // 计算真实滚动次数 因为K可能比较大
        int realK = k % arr.length;

        // 重新修正坐标索引
        int newArr[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int newIdx = i + realK;
            if (newIdx > maxIdx) {
                newIdx -= arr.length;
            }
            newArr[newIdx] = arr[i];
        }

        return newArr;
    }
}
