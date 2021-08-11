package cn.melonkid.study.sort;

import cn.melonkid.study.LoggerUtil;
import cn.melonkid.study.RandomUtil;
import cn.melonkid.study.sort.util.CommonUtil;
import org.junit.Test;

/**
 * 快速排序测试类
 *
 * @author imelonkid
 * @date 2021/08/10 18:05
 **/
public class QuickSortTest extends BaseTester{


    @Test
    public void testSort() {
        SortAlgorithm sortAlgorithm = new QuickSort();
//        int[] testArr = RandomUtil.randomIntArr(1, 100, 5);
        int[] testArr = new int[]{1,2,3,4,5,6};
        CommonUtil.printArr(logger, "原始数组", testArr);
        sortAlgorithm.sort(testArr);
        CommonUtil.printArr(logger, "排序数组", testArr);

//        // 数组存在重复数据
//        LoggerUtil.info(logger, "test2 存在重复数据：");
//        testArr = new int[]{82,43,6,6,16,81,65,96,32,87};
//        CommonUtil.printArr(logger, "原始数组", testArr);
//        sortAlgorithm.sort(testArr);
//        CommonUtil.printArr(logger, "排序数组", testArr);
    }
}
