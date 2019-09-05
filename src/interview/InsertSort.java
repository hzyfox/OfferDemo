package interview;

import leetcode.util.Helper;

/**
 * 插入排序
 */
public class InsertSort {
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int target = array[i];
            for (int j = i; j > 0; j--) {
                if (target < array[j-1]) {
                    array[j] = array[j-1];
                }else {
                    array[j] = target;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] array = {1,2,5,4,3};
        insertSort.sort(array);
        System.out.println(Helper.intArrayToString(array));
    }

}
