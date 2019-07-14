package NiuKeLeetCode;

import leetcode.util.Helper;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */
public class SelectSort {
    public void sort(int[] array){
        for(int i = 0; i< array.length-1; i++){
            int minIndex = i;
            int min = array[i];
            for(int j = i+1; j< array.length; j++){
                if(array[j] < min){
                    min = array[j];
                    minIndex = j;
                }
            }
            int tmp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,4,3,5};
        SelectSort selectSort = new SelectSort();
        selectSort.sort(array);
        System.out.println(Helper.intArrayToString(array));

    }
}
