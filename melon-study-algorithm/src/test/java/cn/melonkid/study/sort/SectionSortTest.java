package cn.melonkid.study.sort;

import cn.melonkid.study.sort.review.QuickSort0820;
import org.junit.Test;

/**
 * SectionSort
 *
 * @author imelonkid
 * @date 2021/08/23 15:07
 **/
public class SectionSortTest extends BaseTester{

    @Test
    public void testSort(){
        BubbleSort bubbleSort = new BubbleSort();
        SortAlgorithm sortAlgorithm = new SectionSort();
        executeSortAndCheck(10_000, 10, bubbleSort, sortAlgorithm);
    }
}
