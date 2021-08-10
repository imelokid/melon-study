package cn.melonkid.study.sort;


import cn.melonkid.study.sort.util.CommonUtil;

/**
 * 冒泡排序算法
 *
 * @author imelonkid
 * @date 2021/08/10 11:53
 **/
public class BubbleSort implements SortAlgorithm {


    @Override
    public void sort(int[] sourceArr) {
        // 指针i
        for (int i = 0; i < sourceArr.length - 1; i++) {
            // 指针j
            for (int j = i + 1; j < sourceArr.length; j++) {
                if (sourceArr[i] > sourceArr[j]) {
                    // 交换
                    CommonUtil.switchNum(sourceArr, i, j);
                }
            }
        }
    }
}
