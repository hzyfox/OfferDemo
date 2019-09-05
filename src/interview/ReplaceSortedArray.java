package interview;

import leetcode.util.Helper;

/**
 * 基本有序数组的替换
 */
public class ReplaceSortedArray {
    public static void replaceSortedArray(int[] A, int[] B) {
        int pre = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] < pre) {
                int left0 = Integer.MIN_VALUE;
                int right0 = A[i];
                int left1 = A[i - 1];
                int right1 = Integer.MAX_VALUE;

                if (i - 2 >= 0) {
                    left0 = A[i - 2];
                }
                if (i + 1 < A.length) {
                    right1 = A[i + 1];
                }
                int max0 = Integer.MIN_VALUE;
                int max1 = Integer.MIN_VALUE;
                for (int j = 0; j < B.length; j++) {
                    if (B[j] > left0 && B[j] < right0) {
                        max0 = Math.max(max0, B[j]);
                    }
                    if (B[j] > left1 && B[j] < right1) {
                        max1 = Math.max(max1, B[j]);
                    }
                }
                if (max0 == Integer.MIN_VALUE && max1 == Integer.MIN_VALUE) {
                    System.out.println(-1);
                    return;
                }
                if (max0 > max1) {
                    A[i - 1] = max0;
                } else {
                    A[i] = max1;
                }
                System.out.println(Helper.intArrayToString(A));
                return;
            }
            pre = A[i];
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 5, 7, 8, 6};
        int[] B = {-1, 9};
        replaceSortedArray(A, B);
    }
}
