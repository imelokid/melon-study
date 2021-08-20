package cn.melonkid.study.sort;

/**
 * 插入排序
 *
 * @author imelonkid
 * @date 2021/08/11 16:55
 **/
public class InsertSort implements SortAlgorithm {


    @Override
    public void sort(int[] sourceArr) {

        // 左手有一张牌
        for(int i = 1; i < sourceArr.length; i++) {
            int numWaitSort = sourceArr[i];
            for(int j = i - 1; j >=0; j--) {
                int numSorted = sourceArr[j];
                if() {

                }
            }
        }
    }
}
