package interview;

import leetcode.util.Helper;

/**
 * 冒泡排序
 */
public class PopSort {
    public void popSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]){
                    int tmp  = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5,4,3,2,1};
        PopSort popSort = new PopSort();
        popSort.popSort(array);
        System.out.println(Helper.intArrayToString(array));
    }
}
