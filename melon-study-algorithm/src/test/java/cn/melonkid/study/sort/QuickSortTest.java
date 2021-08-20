package cn.melonkid.study.sort;

import cn.melonkid.study.sort.review.QuickSort0820;
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

        QuickSort0820 quickSort0820 = new QuickSort0820();
        // 执行比较
        executeSortAndCheck(10_000, 10, bubbleSort, sortAlgorithm);

        /*
            覆盖 r < l的情况
         */
        int arr[] = new int[]{3,2,3,3,4,5,6};
        sortAlgorithm.sort(arr);

        /*
            覆盖数组扫描时位置交换
            从左向右扫描时，指针最终会停在2上
            从右向左扫描时，指正会停在4上
            这时会发生位置交换
         */
        int arr1[] = new int[]{1,1,2,1,0,3,2};
        sortAlgorithm.sort(arr1);

        /**
         * 覆盖r==l的情况
         * 如下数组，从左向右 指针停留在2
         * 从右向左，指针也停留在2
         * 这时2就是要找的位置，不需要继续扫描了，否则下一次循环，会出现数组溢出
         */
        int arr2[] = new int[]{3,3,2};
        quickSort0820.sort(arr2);

    }
}
