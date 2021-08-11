package cn.melonkid.study.sort;

import cn.melonkid.study.RandomUtil;
import cn.melonkid.study.sort.util.CommonUtil;

/**
 * 快速排序
 *
 * @author imelonkid
 * @date 2021/08/10 17:50
 **/
public class QuickSort implements SortAlgorithm {

    @Override
    public void sort(int[] sourceArr) {
        quickSort(sourceArr, 0, sourceArr.length - 1);
    }

    /**
     * 快速排序实现核心
     * 快排的核心思路：就是将给定数组拆分为三段：
     * 基准位：随机选取一个元素作为基准位
     * 左子数组：所有元素小于基准位的数组元素
     * 右子数组：所有元素大于基准位的数组元素
     * 然后通过递归的方式，分别对左右子数组进行排序
     * <p>
     * 这里是一个递归函数，所以需要有终止条件
     * 通过上面的核心思路我们可知，当数组只剩下一个元素时，就不需要继续进行递归了。所以递归
     * 的终止条件应该是：startPos == endPos
     *
     * @param arr      原始数组
     * @param startPos 起始位置
     * @param endPos   结束位置
     */
    private void quickSort(int[] arr, int startPos, int endPos) {
        // 递归终止条件
        if(startPos >= endPos) {
            return;
        }

        // 分区并获取分区位置
        int pos = partition(arr, startPos, endPos);

        // 递归排序左右子数组
        quickSort(arr, startPos, pos - 1);
        quickSort(arr, pos + 1, endPos);
    }

    /**
     * 对给定数组进行分区
     *
     * @param arr 给定数组
     * @param lo  数组起始位置
     * @param hi    数组终止位置
     * @return  获取基准位
     */
    private int partition(int[] arr, int lo, int hi) {
        // 获取基准位元素 这里其实可以随机获取，为了方便起见，这里就取第一元素作为基准
        int idex = RandomUtil.randomInt(lo, hi + 1);
        int seed = arr[idex];

        int l = lo - 1;
        int r = hi + 1;

        // 当数组还没有遍历完成时，循环一致进行
        while(true) {
            // 从右向左 右边元素小于基准位时结束循环 如果r == lo时，也终止循环
            while(arr[--r] >= seed) {
                if(r == lo) {
                    break;
                }
            }

            // 从左向右扫描 当左边的元素大于基准元素时 循环结束 并且如果r == hi时，退出循环
            while(arr[++l] <= seed) {
                if(l == hi) {
                    break;
                }
            }

            // 走到这里，说明数组还在扫描
            if(r <= l) {
                break;
            }

            // 执行交换
            CommonUtil.switchNum(arr, l, r);
        }

        // 将基准位放置到正确的位置上
        CommonUtil.switchNum(arr, idex, r);
        return r;
    }





}
