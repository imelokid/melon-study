package cn.melon.study;

import org.junit.Test;

/**
 * LeetCode_53_MaxSumSubLisOfList
 *
 * @author imelonkid
 * @date 2021/09/20 09:52
 **/
public class LeetCode_53_MaxSumSubLisOfListTest {

    private LeetCode_53_MaxSumSubLisOfList sumSubLisOfList = new LeetCode_53_MaxSumSubLisOfList();

    @Test
    public void testMaxSubArray() {
        int [] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int ret = sumSubLisOfList.maxSubArray(nums);
        System.out.println(ret);
        nums = new int[]{-1, -2, -3, -4, -5};
        ret = sumSubLisOfList.maxSubArray(nums);
        System.out.println(ret);
    }

    @Test
    public void testDpSolution() {
        int [] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int ret = sumSubLisOfList.solution1(nums);
        System.out.println(ret);
        nums = new int[]{-1, -2, -3, -4, -5};
        ret = sumSubLisOfList.solution1(nums);
        System.out.println(ret);
    }
}
