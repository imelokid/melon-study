package cn.melonkid.study.sort;

import org.junit.Test;

/**
 * 希尔排序
 *
 * @author imelonkid
 * @date 2021/08/23 18:41
 **/
public class ShellSortTest extends BaseTester {

    @Override
    @Test
    public void testSort() {
        BubbleSort bubbleSort = new BubbleSort();
        SortAlgorithm sortAlgorithm = new ShellSort();
        executeSortAndCheck(10_000, 10, bubbleSort, sortAlgorithm);
    }
}
