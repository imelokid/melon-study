package cn.melon.study;

/**
 * 最大和子序列问题
 *
 * @author imelonkid
 * @date 2021/09/20 09:49
 **/
public class LeetCode_53_MaxSumSubLisOfList {


    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int preSum = 0;

        for(int i = 0; i < nums.length; i++) {
            if(preSum < 0) {
                preSum = 0;
            }

            preSum += nums[i];
            maxSum = Math.max(maxSum, preSum);
        }

        return maxSum;
    }

    public int solution(int[] nums) {
        int[] transArr = new int[nums.length];
        int transStatus = 0;

        // 状态转移
        for(int i = 0; i < nums.length; i++) {
            transStatus += nums[i];
            transStatus = Math.max(transStatus, nums[i]);
            transArr[i] = transStatus;
        }

        // 找最优解
        int bestStatus = transArr[0];
        for(int i = 0; i < transArr.length; i++) {
            bestStatus = Math.max(bestStatus, transArr[i]);
        }

        return bestStatus;
    }

    public int solution1(int[] nums) {

        int bestStatus = 0;
        int transStatus = 0;

        // 状态转移
        for(int i = 0; i < nums.length; i++) {
            transStatus += nums[i];
            transStatus = Math.max(transStatus, nums[i]);

            if(i == 0) {
                bestStatus = transStatus;
            }
            bestStatus = Math.max(bestStatus, transStatus);
        }

        return bestStatus;
    }
}
