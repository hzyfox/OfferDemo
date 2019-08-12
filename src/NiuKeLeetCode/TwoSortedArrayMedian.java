package NiuKeLeetCode;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */
public class TwoSortedArrayMedian {
    public static double twoSortedArrayMedian(int[] A, int[] B) {
        int leftMiddle = (A.length + B.length + 1) / 2;
        int rightMiddle = (A.length + B.length + 2) / 2;
        return (findMiddleHelper(A, 0, B, 0, leftMiddle) + findMiddleHelper(A, 0, B, 0, rightMiddle)) / 2.0;
    }

    public static int findMiddleHelper(int[] A, int aStart, int[] B, int bStart, int middle) {
        if (aStart + 1 > A.length) {
            return B[bStart + middle - 1];
        }
        if (bStart + 1 > B.length) {
            return A[aStart + middle - 1];
        }
        if (middle == 1) {
            return Math.min(A[aStart], B[bStart]);
        }
        int minA = Integer.MAX_VALUE;
        int minB = Integer.MAX_VALUE;
        if (aStart + middle / 2 - 1 < A.length) {
            minA = A[aStart + middle / 2 - 1];
        }
        if (bStart + middle / 2 - 1 < B.length) {
            minB = A[aStart + middle / 2 - 1];
        }
        if (minA < minB) {
            return findMiddleHelper(A, aStart + middle / 2, B, bStart, middle - middle / 2);
        } else {
            return findMiddleHelper(A, aStart, B, bStart + middle / 2, middle - middle / 2);
        }
    }
}
