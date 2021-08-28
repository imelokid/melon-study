package cn.melonkid.study.sort;

import cn.melonkid.study.sort.util.CommonUtil;

/**
 * 希尔排序
 *
 * 思路：
 * 希尔排序是插入排序的一种改进，插入排序
 *
 * @author imelonkid
 * @date 2021/08/23 16:34
 **/
public class ShellSort implements SortAlgorithm {

    @Override
    public void sort(int[] sourceArr) {
//
//        // 定义增量
//        int gap = sourceArr.length/2;
//        while(gap > 1) {
//
//            for(int i = 0; i < gap; i++) {
//                for(int j = i; j < sourceArr.length; j+=gap) {
//                    int currPos = j ;
//                    for(int k = j - gap; k >=0; k-=gap) {
//                        if(sourceArr[currPos] < sourceArr[k]) {
//                            CommonUtil.switchNum(sourceArr, currPos, j);
//                            currPos -= gap;
//                        }
//                    }
//                }
//
//            }
//
//            gap /= 2;
//        }
    }
}
