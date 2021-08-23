package cn.melonkid.study.sort;

import cn.melonkid.study.sort.util.CommonUtil;

/**
 * 选择排序
 * 思路：将给定数据分成两部分，左边部分是有序数组，右边部分是无序数组
 * 从无序数组中找到最值元素，将元素依次追加到有序数组末尾。直到无序数组所有元素都
 * 放置到了有序数组中为止。
 *
 * @author imelonkid
 * @date 2021/08/11 17:17
 **/
public class SectionSort implements SortAlgorithm {

    @Override
    public void sort(int[] sourceArr) {
        // 最小元素位置
        int minPos;

        for (int i = 0; i < sourceArr.length; i++) {
            // 寻找最小元素
            minPos = i;
            for (int j = i; j < sourceArr.length; j++) {
                if (sourceArr[minPos] > sourceArr[j]) {
                    minPos = j;
                }
            }
            CommonUtil.switchNum(sourceArr, i, minPos);
        }
    }
}
