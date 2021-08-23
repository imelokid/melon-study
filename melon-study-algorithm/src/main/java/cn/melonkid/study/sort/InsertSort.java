package cn.melonkid.study.sort;

import cn.melonkid.study.sort.util.CommonUtil;

/**
 * 插入排序
 * 思路：与选择排序类似，就是将数组分为左右两部分。左边有序，右边无序
 *
 * @author imelonkid
 * @date 2021/08/11 16:55
 **/
public class InsertSort implements SortAlgorithm {


    @Override
    public void sort(int[] sourceArr) {
        for (int i = 0; i < sourceArr.length; i++) {
            int selectPos = i;
            for (int j = selectPos - 1; j >= 0; j--) {
                if (sourceArr[selectPos] < sourceArr[j]) {
                    CommonUtil.switchNum(sourceArr, selectPos, j);
                    selectPos = j;
                }
            }
        }
    }
}
