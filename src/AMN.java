package jvm.heap;

import java.util.ArrayList;

/**
 * create with jvm.heap
 * USER: husterfox
 */
public class AMN {
    public static void main(String[] args) {
        printPermutation(4, 3);
    }

    public static void printPermutation(int m, int n) {
        if (m < n) {
            return;
        }
        int[] array = new int[m];
        for (int i = 0; i < m; i++) {
            array[i] = i + 1;
        }
        ArrayList<Integer> selectedNums = new ArrayList<>();
        find(array, selectedNums, n);
    }

    public static void find(int[] array, ArrayList<Integer> selectedNums, int leftNumber) {
        for (int i = 0; i < array.length; i++) {
            if (leftNumber == 0) {
                System.out.println(selectedNums.toString());
                return;
            }
            if (selectedNums.contains(array[i])) {
                continue;
            }
            int index = selectedNums.size();
            selectedNums.add(array[i]);
            find(array, selectedNums, leftNumber - 1);
            selectedNums.remove(index);
        }
    }
}
