package cn.melonkid.study.thread.synchronize;

/**
 * @author imelonkid
 * @date 2021/09/02 20:37
 **/
public class ArrMerge {


    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {6, 7, 8, 9, 10};

        int[] finalArr = merge(arr1, arr2);
        System.out.println(finalArr);
    }


    /**
     * 合并数组
     */
    private static int[] merge(int[] arr1, int[] arr2) {

        int[] finalArr = new int[arr1.length + arr2.length];

        for (int i = 0; i < finalArr.length; i++) {
            // 需要的值
            int needVal = findVal(arr1, arr2, i);
            finalArr[i] = needVal;
        }

        return finalArr;
    }


    private static int findVal(int[] arr1, int[] arr2, int idx) {
        if (idx >= arr1.length) {
            idx = idx - arr1.length;
            return arr1[idx] <= arr2[idx] ? arr2[idx] : arr1[idx];
        }


        return arr1[idx] <= arr2[idx] ? arr1[idx] : arr2[idx];
    }

}
