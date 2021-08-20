package cn.melonkid.study.sort;

import cn.melonkid.study.RandomUtil;
import cn.melonkid.study.sort.util.CommonUtil;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基础测试类
 *
 * @author imelonkid
 * @date 2021/08/10 16:27
 **/
public class BaseTester {

    /** LOGGER */
    protected Logger logger = LoggerFactory.getLogger(BaseTester.class);

    protected void executeSortAndCheck(int times, int arrLen, SortAlgorithm baseAlgorithm, SortAlgorithm sortAlgorithm) {
        for(int i = 0; i < times; i++) {
            int[] testArr = RandomUtil.randomIntArr(1, 100, arrLen);
            int[] checkArr = Arrays.copyOf(testArr, testArr.length);
            int[] orgArr = Arrays.copyOf(testArr, testArr.length);

            try{
                // 执行比较
                sortAlgorithm.sort(testArr);
                baseAlgorithm.sort(checkArr);
            }catch (Exception e){
                CommonUtil.printArr(logger, "原始数组:", orgArr);
                CommonUtil.printArr(logger, "排序数组:", testArr);
                throw e;
            }


            if(!CommonUtil.equals(testArr, checkArr)) {
                CommonUtil.printArr(logger, "原始数组:", orgArr);
                CommonUtil.printArr(logger, "排序数组:", testArr);
                assert !CommonUtil.equals(testArr, checkArr);
            }
        }
    }
}
