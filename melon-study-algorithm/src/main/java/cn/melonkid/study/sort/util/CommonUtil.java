package cn.melonkid.study.sort.util;

import cn.melonkid.study.LoggerUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

/**
 * 通用工具类工具
 *
 * @author imelonkid
 * @date 2021/08/10 11:55
 **/
public class CommonUtil {


    /**
     * 打印给定数组
     *
     * @param arr 要打印的数组
     */
    public static void printArr(Logger logger, String desc, int[] arr) {
        if(StringUtils.isBlank(desc)) {
            desc = "arr is";
        }
        if(arr == null || arr.length < 1) {
            logger.info(desc + ":[Empty Arr...]");
        }

        StringBuilder sb = new StringBuilder(desc);
        sb.append(":[");
        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + ", ");
        }
        String printMgs = sb.substring(0, sb.length() - 2);
        printMgs += "]";

        // 输出
        LoggerUtil.info(logger, printMgs);
    }

    /**
     * 数据交换
     * @param arr   操作数组
     * @param pos1  交换位置1
     * @param pos2  交换位置2
     * @return  交换后的数组
     */
    public static void switchNum(int[] arr, int pos1, int pos2){

        // 异常情况，不交换
        if(arr == null || arr.length < 1) {
            return;
        }
        if(pos1 >= arr.length || pos2 >= arr.length) {
            return;
        }

        // 同一个位置就不交换了
        if(pos1 == pos2) {
            return;
        }

        // 这种写法有一个BUG，就是当pos1 == pos2时，会将两个位置的值都设置为0
        // a = a ^ b
        arr[pos1] = arr[pos1] ^ arr[pos2];
        // a = a ^ b ^ b -> a ^ (b ^ b) = a;
        arr[pos2] = arr[pos1] ^ arr[pos2];
        // a = a ^ b ^ a -> b ^ (a ^ a) = b;
        arr[pos1] = arr[pos1] ^ arr[pos2];
    }


}
