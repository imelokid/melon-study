package cn.melon.study;

/**
 * 最大箱子数
 * 有一批货，体积大小随机，有一批箱子，体积固定为3.
 * 不考虑货物的体积，求给定货物最多能装满几个箱子。
 * <p>
 * 说明：体积为6的货物可以用2个箱子装完，体积为7的箱子
 * 不能被箱子装下
 * <p>
 * <p>
 * 思路：当货物的体积为3的整数倍时，货物可以刚好装满箱子
 * 当货物体积除以3余1时，将货物中货物提交除3余1的货物剔除一个即可转满箱子
 * 当货物体积除以3余2时，将货物中除3余1的两个货物或者除3余2的一个货物剔除，剩下的
 * 货物就能刚好装满N个箱子
 * <p>
 * 因为要求N最大，所以这里要剔除的货物体积应该要最小
 *
 * @author imelonkid
 * @date 2021/09/21 11:53
 **/
public class MaxBoxProblem {

    public int solution(int[] arr) {
        // 分别记录除3余1和除3余2的货物
        int[] mode1 = new int[2];
        int mode2 = 0;

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 3 == 1) {
                // 一个余数为1的数都没有
                if (mode1[0] == 0) {
                    mode1[0] = arr[i];
                    sum += arr[i];
                    continue;
                }

                // 将最小的放到mode1[0] 将次小的放到mode1[1]
                if (mode1[0] > arr[i]) {
                    mode1[1] = mode1[0];
                    mode1[0] = arr[i];
                    sum += arr[i];
                    continue;
                }

                if (mode1[1] > arr[i]) {
                    mode1[1] = arr[i];
                    sum += arr[i];
                    continue;
                }

                if (mode1[1] == 0) {
                    mode1[1] = arr[i];
                    sum += arr[i];
                    continue;
                }

            }

            if (arr[i] % 3 == 2) {
                if (mode2 == 0) {
                    mode2 = arr[i];
                    sum += arr[i];
                    continue;
                }

                if (mode2 > arr[i]) {
                    mode2 = arr[i];
                }
            }

            sum += arr[i];
        }

        int mode = sum % 3;
        if(mode == 0) {
            return sum / 3;
        }

        if (mode == 1) {
            return (sum - mode1[0]) / 3;
        }

        if(mode1[0] == 0 || mode1[1] == 0) {
            return (sum - mode2) / 3;
        }

        int nums = mode1[0] + mode1[1];
        if (nums > mode2) {
            return (sum - mode2) / 3;
        }

        return (sum - nums) / 3;
    }
}
