package swordoffer;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class Multiple {
    public int[] multiply(int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        int[] end = new int[A.length];
        left[0] = 1;
        right[A.length - 1] = 1;
        for (int i = 1; i < A.length; i++) {
            left[i] = A[i - 1] * left[i - 1];
        }
        for (int i = A.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * A[i + 1];
        }
        for (int i = 0; i < A.length; i++) {
            end[i] = left[i] * right[i];
        }
        return end;

    }
}
