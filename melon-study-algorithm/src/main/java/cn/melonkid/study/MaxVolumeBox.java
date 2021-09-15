package cn.melonkid.study;

/**
 * 存在一堆商品，要装到箱子中。已知箱子的容积是3，也知道每个商品的体积。不考虑商品的形状，假设只要N个商品的体积加和，恰好是3，就可以装进箱子。而且，如果商品的体积超过了3，只要恰好是箱子体积的倍数，可以把多个箱子拼成1个大箱子，来装商品。
 * 比如：2个商品，体积加起来是6，可以用2个箱子来装载。
 * 如果加起来是7，就不行了，必须得扔掉某个商品，再继续看能不能装进去。
 * 找出一批商品，恰好装满M个箱子。你能找到的最大的M，是多少？
 *
 * @author imelonkid
 * @date 2021/09/14 14:52
 **/
public class MaxVolumeBox {

    /**
     * arr=[3, 6, 5, 1, 8] m=6 需要6个箱子
     * @param arr
     * @return
     */
    public int findMaxSize(int[] arr) {
        if(arr == null || arr.length < 1) {
            return 0;
        }
        int tmp = 0;
        for(int i = 0; i < arr.length; i++) {
            tmp += arr[i];


        }
        Integer tmp1 = null;
        int mod = tmp % 3;
        for (int i = 0; i < arr.length; i++) {
            // 排除最小的连个1和连个2
            if(mod == 2) {

            }
            if(arr[i] % 3 == mod) {
                tmp1 = (tmp1 == null)? arr[i] : Math.min(arr[i], tmp1);
            }
        }

        return tmp - tmp1;
    }
}
