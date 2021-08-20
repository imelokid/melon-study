package cn.melonkid.study.sort.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 通用工具测试类
 *
 * @author imelonkid
 * @date 2021/08/10 12:29
 **/
public class CommonUtilTest {

    /** LOGGER */
    private Logger logger = LoggerFactory.getLogger(CommonUtilTest.class);

    @Test
    public void testPrintArr() {
        int[] arr = {2, 0, 11, 334, 0, 9};
        CommonUtil.printArr(logger, "", arr);
    }

    @Test
    public void testSwitchNum() {
        int[] arr = {2, 0, 11, 334, 0, 9};
        CommonUtil.switchNum(arr, 1, 2);
        CommonUtil.printArr(logger, "", arr);

        CommonUtil.switchNum(arr, 1, 1);
        CommonUtil.printArr(logger, "", arr);
    }

    @Test
    public void testEquals() {
        int[] arr = {2, 0, 11, 334, 0, 9};
        int[] arr1 = {2, 0, 111, 334, 0, 9};
        assert !CommonUtil.equals(arr, arr1);
    }

    @Test
    public void testEquals1() {
        int[] arr = {2, 0, 11, 334, 0, 9};
        int[] arr1 = {2, 0, 11, 334, 0, 9};
        assert CommonUtil.equals(arr, arr1);
    }

}
