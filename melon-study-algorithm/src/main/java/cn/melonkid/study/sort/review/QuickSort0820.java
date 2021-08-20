package cn.melonkid.study.sort.review;

import cn.melonkid.study.sort.SortAlgorithm;
import cn.melonkid.study.sort.util.CommonUtil;

/**
 * 快排复习
 *
 * @author imelonkid
 * @date 2021/08/20 11:26
 **/
public class QuickSort0820 implements SortAlgorithm {


    @Override
    public void sort(int[] sourceArr) {
        quickSort(sourceArr, 0, sourceArr.length -1);
    }


    /**
     * 快排核心实现类
     *
     * @param sourceArr 原始数组
     * @param startPos  起始位置
     * @param endPos    结束位置
     */
    public void quickSort(int[] sourceArr, int startPos, int endPos) {
        // 递归结束判断
        if(startPos > endPos) {
            return;
        }

        // 分区
        int pos = partition(sourceArr, startPos, endPos);

        // 重排左右分区
        quickSort(sourceArr, startPos, pos - 1);
        quickSort(sourceArr, pos + 1, endPos);
    }

    /**
     * 对数组进行分区
     *
     * @param sourceArr 原始数组
     * @param startPos  起始位置
     * @param endPos    结束位置
     * @return
     */
    private int partition(int[] sourceArr, int startPos, int endPos) {

        // 选择参考位置，这里选择第一个
        int seed = sourceArr[startPos];
        int lo = startPos;
        int hi = endPos;

        // 开始扫描
        while(true) {
            // 从右向左扫描
            while(sourceArr[hi] >= seed) {
                hi--;
                if(hi <= lo) {
                   break;
                }
            }

            // 循环到了头了，说明seed在数组中最小
            if(lo == hi) {
                break;
            }

            // 从左向右扫描
            while(sourceArr[lo++] <= seed) {
                if(lo > hi) {
                    break;
                }
            }
            CommonUtil.switchNum(sourceArr, startPos, hi);
        }

        return hi;
    }
}
