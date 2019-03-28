package swordoffer;

import java.util.ArrayList;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (k > input.length || k<=0) {
            return ans;
        }
        quickSort(input, 0, input.length - 1, k);
        for (int i = 0; i < k && i < input.length; i++) {
            ans.add(input[i]);
        }
        return ans;
    }

    public void quickSort(int[] input, int start, int end, int k) {
        if (start >= end) {
            return;
        }
        int first = start;
        int last = end;
        int key = input[start];
        while (first < last) {
            while (start < last && input[last] > key) {
                last--;
            }
            input[first] = input[last];
            while (first < last && input[first] < key) {
                first++;
            }
            input[last] = input[first];
        }
        input[first] = key;
        if (first >= key - 1) {
            return;
        } else {
            quickSort(input, first + 1, end, k);
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(new GetLeastNumbers().GetLeastNumbers_Solution(array, 4));
    }

}
