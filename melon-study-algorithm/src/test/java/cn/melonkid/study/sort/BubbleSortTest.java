package cn.melonkid.study.sort;

import cn.melonkid.study.LoggerUtil;
import cn.melonkid.study.RandomUtil;
import cn.melonkid.study.sort.util.CommonUtil;
import org.junit.Test;

/**
 * 冒泡排序测试类
 *
 * @author imelonkid
 * @date 2021/08/10 15:31
 **/
public class BubbleSortTest extends BaseTester {

    @Test
    public void testSort() {
        SortAlgorithm sortAlgorithm = new BubbleSort();
        int[] testArr = RandomUtil.randomIntArr(1, 100, 10);
        CommonUtil.printArr(logger, "原始数组", testArr);
        sortAlgorithm.sort(testArr);
        CommonUtil.printArr(logger, "排序数组", testArr);

        // 数组存在重复数据
        LoggerUtil.info(logger, "test2 存在重复数据：");
        testArr = new int[]{82,43,6,6,16,81,65,96,32,87};
        CommonUtil.printArr(logger, "原始数组", testArr);
        sortAlgorithm.sort(testArr);
        CommonUtil.printArr(logger, "排序数组", testArr);
    }
}
