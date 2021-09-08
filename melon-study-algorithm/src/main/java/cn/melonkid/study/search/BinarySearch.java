package cn.melonkid.study.search;

/**
 * 二分查找
 *
 * @author imelonkid
 * @date 2021/09/04 17:47
 **/
public class BinarySearch {

    public int binerySearch(int[] arr, int val) {

        int startIdx = 0;
        int endIdx = arr.length;

        // init -> [0, arr.length)
        while (startIdx < endIdx) {
            int mid = startIdx + (endIdx - startIdx) / 2;
            if (arr[mid] == val) {
                return mid;
            }

            // -> [0, mid)
            if (val < arr[mid]) {
                endIdx = mid;
            }

            // -> (mid，endIdx]
            if (val > arr[mid]) {
                startIdx = mid + 1;
            }
        }

        return -1;
    }


    /**
     * 递归实现
     * @param arr
     * @param val
     * @return
     */
    public int binarySearch1(int[] arr, int val){
        int startPos = 0;
        int endPos = arr.length;

        return search(arr, val, startPos, endPos);
    }

    private int search(int[] arr, int val, int startPos, int endPos) {
        // 搜索到了边界
        if(startPos == arr.length || endPos == 0) {
            return -1;
        }

        // 计算中间位置
        int midPos = startPos + (endPos - startPos)/2;
        if(arr[midPos] == val) {
            return midPos;
        }

        // 左区间
        if(val < arr[midPos]) {
            return search(arr, val, startPos, midPos);
        }

        // 右区间
        return search(arr, val, midPos, endPos);
    }

    public static void main(String[] args) {
        int a = 1 >> 1;
        System.out.println(3>>1);
    }

}
