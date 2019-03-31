package swordoffer;

import leetcode.util.Helper;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (k > input.length || k <= 0) {
            return ans;
        }
        int[] bigRootHeap = createBigRootHeap(input, k, true);
        for (int i = k; i < input.length; i++) {
            maintainBigRootHeap(bigRootHeap, input[i]);
        }
        for (int i = 0; i < k; i++) {
            ans.add(bigRootHeap[i]);
        }
        return ans;
    }

    public void maintainBigRootHeap(int[] bigRootHeap, int i) {
        if (i < bigRootHeap[0]) {
            bigRootHeap[0] = i;
            createBigRootHeap(bigRootHeap, bigRootHeap.length, false);
        }
    }

    public int[] createBigRootHeap(int[] input, int k, boolean copy) {
        int[] bigRootHeap;
        if (copy) {
            bigRootHeap = Arrays.copyOfRange(input, 0, k);
        } else {
            bigRootHeap = input;
        }

        for (int i = 1; i < k; i++) {
            int j = i;
            while (j > 0) {
                int parent = (j - 1) / 2;
                if (bigRootHeap[parent] < bigRootHeap[j]) {
                    int tmp = bigRootHeap[parent];
                    bigRootHeap[parent] = bigRootHeap[j];
                    bigRootHeap[j] = tmp;
                    j = parent;
                } else {
                    break;
                }
            }
        }
        return bigRootHeap;
    }

    public void quickSort(int[] input, int start, int end, int k) {
        if (start >= end) {
            return;
        }
        int first = start;
        int last = end;
        int key = input[start];
        while (first < last) {
            while (first < last && input[last] > key) {
                last--;
            }
            input[first] = input[last];
            while (first < last && input[first] < key) {
                first++;
            }
            input[last] = input[first];
        }
        input[first] = key;
        if (first == k) {
            return;
        } else {
            if (first > k) {
                quickSort(input, start, first - 1, k);
            } else {
                quickSort(input, first + 1, end, k);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(new GetLeastNumbers().GetLeastNumbers_Solution(array, 2));
    }

}
