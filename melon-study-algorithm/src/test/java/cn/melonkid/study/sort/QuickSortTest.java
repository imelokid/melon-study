package cn.melonkid.study.sort;

import cn.melonkid.study.LoggerUtil;
import cn.melonkid.study.RandomUtil;
import cn.melonkid.study.sort.review.QuickSort0820;
import cn.melonkid.study.sort.util.CommonUtil;
import java.util.Arrays;
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
        BubbleSort bubbleSort = new BubbleSort();
        SortAlgorithm sortAlgorithm = new QuickSort();

        // 执行比较
        executeSortAndCheck(10_000, 10, bubbleSort, sortAlgorithm);



        // 数组存在重复数据
        LoggerUtil.info(logger, "test2 存在重复数据：");
        int[] testArr = new int[]{1,2,3,5,4,9};
        CommonUtil.printArr(logger, "原始数组", testArr);
        sortAlgorithm.sort(testArr);
        CommonUtil.printArr(logger, "排序数组", testArr);

//        QuickSort0820 quickSort0820 = new QuickSort0820();
//        CommonUtil.printArr(logger, "原始数组", testArr);
//        quickSort0820.sort(testArr);
//        CommonUtil.printArr(logger, "排序数组", testArr);
    }
}
