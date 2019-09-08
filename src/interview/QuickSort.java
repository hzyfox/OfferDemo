package interview;

import leetcode.util.Helper;

/**
 * 快速排序
 */
public class QuickSort {
    public void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int target = array[start];
        int pre = start;
        int last = end;
        while (pre < last) {
            while (last > pre && array[last] > target) {
                last--;
            }
            array[pre] = array[last];
            while (pre < last && array[pre] < target) {
                pre++;
            }
            array[last] = array[pre];
        }
        array[pre] = target;
        quickSort(array, start, pre - 1);
        quickSort(array, pre + 1, end);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = {1,2,5,4,3};
        quickSort.quickSort(array,0, array.length-1);
        System.out.println(Helper.intArrayToString(array));
    }
}
