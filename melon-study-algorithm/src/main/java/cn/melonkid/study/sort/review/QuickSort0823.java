package cn.melonkid.study.sort.review;

import cn.melonkid.study.sort.SortAlgorithm;
import cn.melonkid.study.sort.util.CommonUtil;

/**
 * 快排复习
 *
 * @author imelonkid
 * @date 2021/08/20 11:26
 **/
public class QuickSort0823 implements SortAlgorithm {


    @Override
    public void sort(int[] sourceArr) {
        quickSort(sourceArr, 0, sourceArr.length - 1);
    }


    /**
     * 快排核心实现类
     *
     * @param sourceArr 原始数组
     * @param startPos  起始位置
     * @param endPos    结束位置
     */
    public void quickSort(int[] sourceArr, int startPos, int endPos) {
        if (startPos >= endPos) {
            return;
        }

        // 分区
        int pos = partition(sourceArr, startPos, endPos);
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

        int lo = startPos;
        int hi = endPos + 1;

        int seed = sourceArr[startPos];

        while (true) {
            while (sourceArr[++lo] <= seed) {
                if (lo == endPos) {
                    break;
                }
            }

            while (sourceArr[--hi] >= seed) {
                if (hi == startPos) {
                    break;
                }
            }

            if (lo >= hi) {
                break;
            }

            CommonUtil.switchNum(sourceArr, lo, hi);
        }

        CommonUtil.switchNum(sourceArr, startPos, hi);
        return hi;
    }
}
