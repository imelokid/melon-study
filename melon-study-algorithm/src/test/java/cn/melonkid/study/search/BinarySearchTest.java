package cn.melonkid.study.search;

import cn.melonkid.exception.MelonStatusCodeEnums;
import cn.melonkid.util.AssertUtil;
import org.junit.Test;

/**
 * BinarySearchTest
 *
 * @author imelonkid
 * @date 2021/09/04 17:49
 **/
public class BinarySearchTest {

    @Test
    public void binarySearch() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {1,2,3,4,5,6};

        int idx = binarySearch.binerySearch(arr, 3);
        System.out.println("idx --> " + idx);
        AssertUtil.assertTrue(idx == 2, MelonStatusCodeEnums.SYSTEM_ERROR);

        idx = binarySearch.binerySearch(arr, 1);
        System.out.println("idx --> " + idx);
        AssertUtil.assertTrue(idx == 0, MelonStatusCodeEnums.SYSTEM_ERROR);

        idx = binarySearch.binerySearch(arr, 6);
        System.out.println("idx --> " + idx);
        AssertUtil.assertTrue(idx == 5, MelonStatusCodeEnums.SYSTEM_ERROR);

        idx = binarySearch.binerySearch(arr, 7);
        System.out.println("idx --> " + idx);
        AssertUtil.assertTrue(idx == -1, MelonStatusCodeEnums.SYSTEM_ERROR);

        idx = binarySearch.binerySearch(arr, -1);
        System.out.println("idx --> " + idx);
        AssertUtil.assertTrue(idx == -1, MelonStatusCodeEnums.SYSTEM_ERROR);
    }

    @Test
    public void binarySearch1() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {1,2,3,4,5,6};

        int idx = binarySearch.binarySearch1(arr, 3);
        System.out.println("idx --> " + idx);
        AssertUtil.assertTrue(idx == 2, MelonStatusCodeEnums.SYSTEM_ERROR);

        idx = binarySearch.binarySearch1(arr, 1);
        System.out.println("idx --> " + idx);
        AssertUtil.assertTrue(idx == 0, MelonStatusCodeEnums.SYSTEM_ERROR);

        idx = binarySearch.binarySearch1(arr, 6);
        System.out.println("idx --> " + idx);
        AssertUtil.assertTrue(idx == 5, MelonStatusCodeEnums.SYSTEM_ERROR);

        idx = binarySearch.binarySearch1(arr, 7);
        System.out.println("idx --> " + idx);
        AssertUtil.assertTrue(idx == -1, MelonStatusCodeEnums.SYSTEM_ERROR);

        idx = binarySearch.binarySearch1(arr, -1);
        System.out.println("idx --> " + idx);
        AssertUtil.assertTrue(idx == -1, MelonStatusCodeEnums.SYSTEM_ERROR);
    }


    @Test
    public void divide() {
        // 0.5
        System.out.println(1/2);

        // 1.5
        System.out.println(3/2);

        System.out.println(8/2);
    }

}
