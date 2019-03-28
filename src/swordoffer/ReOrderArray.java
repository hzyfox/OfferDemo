package swordoffer;

import leetcode.util.Helper;

import java.util.Arrays;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class ReOrderArray {
    public void reOrderArray(int[] array) {
//        for (int i = 0; i < array.length - 1; i++) {
//            for (int j = 0; j < array.length - 1 - i; j++) {
//                if ((array[j] & 1) == 0 && (array[j+1] & 1) == 1) {
//                    int tmp = array[j];
//                    array[j] = array[j +1];
//                    array[j + 1] = tmp;
//                }
//            }
//        }
        int i = 0;
        int j = 0;
        for (i = 0; i < array.length - 1; i++) {
            for (j = i; j < array.length; j++) {
                if ((array[j] & 1) == 1) {
                    int tmp = array[j];
                    for (int k = j; k > i; k--) {
                        array[k] = array[k - 1];
                    }
                    array[i] = tmp;
                    break;
                }
            }
        }
    }

    public void reOrder(int[] array, int startPos) {
        if (startPos == array.length) {
            return;
        }
        int i = startPos;
        for (; i < array.length; i++) {
            if ((array[startPos] & 1) == 1) {
                reOrder(array, i + 1);
                return;
            } else {
                break;
            }
        }
        int j = i + 1;
        while (j < array.length) {
            if ((array[j] & 1) == 1) {
                break;
            }
            j++;
        }
        if (j >= array.length) {
            return;
        } else {
            int tmp = array[j];
            for (int k = j - 1; k >= i; k--) {
                array[k + 1] = array[k];
            }
            array[i] = tmp;
            reOrder(array, i + 1);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        new ReOrderArray().reOrderArray(array);
        System.out.println(Helper.intArrayToString(array));
    }
}
