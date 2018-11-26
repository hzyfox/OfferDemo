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
        ArrayList<Integer> selectedNum = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        find(array, selectedNum, 1, result, n);
    }

    public static void find(int[] array, ArrayList<Integer> selectedNum, int selectOrder, ArrayList<Integer> result, int n) {
        int lastIndex0 =0, lastIndex1 = 0;
        for (int i = 0; i < array.length; i++) {
            if (selectedNum.contains(array[i])) {
                continue;
            }
            lastIndex0 = result.size();
            lastIndex1 = selectedNum.size();
            result.add(array[i]);
            selectedNum.add(array[i]);
            if (selectOrder == n) {
                System.out.println(result.toString());
                result.remove(lastIndex0);
                selectedNum.remove(lastIndex1);
                continue;
            }
            find(array, selectedNum, selectOrder + 1, result, n);
            result.remove(lastIndex0);
            selectedNum.remove(lastIndex1);
        }
    }
}
