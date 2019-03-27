package swordoffer;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {

        if (array.length == 0) {
            return 0;
        }
        int lo = 0;
        int hi = array.length - 1;
        while (lo < hi) {
            if (hi - lo == 1) {
                return array[hi];
            }
            while (lo < hi && array[lo] == array[hi]) {
                lo++;
            }

            int mid = (lo + hi) / 2;
            if (array[lo] <= array[mid]) {
                lo = mid;
            }
            if (array[mid] <= array[hi]) {
                hi = mid;
            }
        }
        return array[hi];
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 1, 0, 1};
        System.out.println(new MinNumberInRotateArray().minNumberInRotateArray(array));
    }
}
