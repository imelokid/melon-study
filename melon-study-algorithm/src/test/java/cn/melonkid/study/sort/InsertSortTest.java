package cn.melonkid.study.sort;

import org.junit.Test;

/**
 * InsertSort
 *
 * @author imelonkid
 * @date 2021/08/23 15:41
 **/
public class InsertSortTest extends BaseTester{

    @Override
    @Test
    public void testSort() {
        BubbleSort bubbleSort = new BubbleSort();
        SortAlgorithm sortAlgorithm = new InsertSort();
        executeSortAndCheck(10_000, 10, bubbleSort, sortAlgorithm);
    }
}
