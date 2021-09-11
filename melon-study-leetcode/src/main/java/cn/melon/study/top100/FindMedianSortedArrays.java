package cn.melon.study.top100;

/**
 * findMedianSortedArrays
 *
 * @author imelonkid
 * @date 2021/09/08 20:18
 **/
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        FindMedianSortedArrays sortedArrays = new FindMedianSortedArrays();
        double a = sortedArrays.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});
        System.out.println(a);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 结果数组
        int[] finalNums = new int[nums1.length + nums2.length];

        // 定义两个游标
        int i = 0;
        int j = 0;
        int k = 0;

        // 遍历两个数组
        for(; k < finalNums.length; k++) {
            // 越界检查
            if(i >= nums1.length) {
                finalNums[k] = nums2[j];
                j++;
                continue;
            }
            if(j >= nums2.length) {
                finalNums[k] = nums1[i];
                i++;
                continue;
            }

            int num1 = nums1[i];
            int num2 = nums2[j];

            // 第一个数组的元素小，将元素直接加到结果数组
            if(num1 <= num2) {
                finalNums[k] = num1;
                i++;
                continue;
            }

            // 第二个数组的元素小，将元素加到结果列表
            finalNums[k] = num2;
            j++;
        }

        // 计算结果数组的中位数
        if(finalNums.length % 2 != 0) {
            // 数组中有奇数个元素，中位数就是中间的元素
            return finalNums[(finalNums.length - 1)/2];
        }

        // 数组有偶数个元素，中位数要经过计算
        return (finalNums[(finalNums.length - 1)/2] + finalNums[(finalNums.length - 1)/2 + 1]) * 1.0/2;

    }
}
