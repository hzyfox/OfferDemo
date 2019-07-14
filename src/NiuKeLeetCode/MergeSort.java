package NiuKeLeetCode;

import leetcode.util.Helper;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */
public class MergeSort {
    public void mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (start + end) / 2;
        mergeSort(array, start, middle);
        mergeSort(array, middle + 1, end);
        int[] tmp = new int[end - start + 1];
        int pre = start;
        int last = middle + 1;
        int i = 0;
        while (pre <= middle && last <= end) {
            if (array[pre] < array[last]) {
                tmp[i++] = array[pre];
                pre++;
            } else {
                tmp[i++] = array[last];
                last++;
            }
        }
        while (pre <= middle) {
            tmp[i++] = array[pre++];
        }
        while (last <= end) {
            tmp[i++] = array[last++];
        }
        System.arraycopy(tmp,0,array,start,tmp.length);
    }

    public static void main(String[] args) {
        int[] array = {5,4,3,2,1};
        MergeSort mergeSort= new MergeSort();
        mergeSort.mergeSort(array, 0, array.length-1);
        System.out.println(Helper.intArrayToString(array));
    }
}
