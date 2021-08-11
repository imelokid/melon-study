package cn.melonkid.study;


import cn.melonkid.exception.MelonException;
import cn.melonkid.exception.MelonStatusCodeEnums;

/**
 * 随机数工具
 *
 * @author imelonkid
 * @date 2021/08/10 15:32
 **/
public class RandomUtil {


    /**
     * 生成指定范围的随机数数组
     *
     * @param from 最小值
     * @param to   最大值
     * @param len  数组长度
     * @return 随机数数组
     */
    public static int[] randomIntArr(int from, int to, int len) {
        if (from >= to || from < 1) {
            throw new MelonException(MelonStatusCodeEnums.PARAMS_ILLG, "from:{} to:{}", from, to);
        }

        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = randomInt(from, to);
        }

        return arr;
    }


    /**
     * 生成指定范围的随机整数
     *
     * @param from 随机数最小值
     * @param to   随机数最大值
     * @return 生成的随机数
     */
    public static int randomInt(int from, int to) {
        if (from >= to || from < 0) {
            throw new MelonException(MelonStatusCodeEnums.PARAMS_ILLG, "from:{} to:{}", from, to);
        }

        return (int) (from + (Math.random() * (to - from)));
    }
}
