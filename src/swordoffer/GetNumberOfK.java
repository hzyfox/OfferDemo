package swordoffer;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class GetNumberOfK {
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int lo = findLowerBound(array, k);
        if (lo >= array.length || array[lo] != k) {
            return 0;
        }
        int hi = findLowerBound(array, k + 1);
        return hi - lo;
    }

    public int findLowerBound(int[] array, int k) {
        int start = 0;
        int end = array.length;
        while (start <= end) {
            //这样结果如果存在一定会收敛到值得左边
            //如果值不存在，则会找到最接近该值得下标.
            int mid = (start + end) >> 1;
            if (array[mid] <= k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
