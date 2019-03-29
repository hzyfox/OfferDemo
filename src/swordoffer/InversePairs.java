package swordoffer;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class InversePairs {
    int cnt = 0;

    public int InversePairs(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        mergeUp2Down(array, 0, array.length - 1);
        return cnt%1000000007;
    }

    public void mergeUp2Down(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) >> 1;
        mergeUp2Down(array, start, mid);
        mergeUp2Down(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    public void merge(int[] array, int start, int mid, int end) {
        int[] copy = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                copy[k++] = array[i++];
            } else {
                copy[k++] = array[j++];
                //因为下标i已经可以和右边j构成有序对了,说明 i后面一直到mid 都可以和j构成有序对。
                cnt = cnt + mid - i + 1;
            }
        }

        while (i <= mid) {
            copy[k++] = array[i++];
        }

        while (j <= end) {
            copy[k++] = array[j++];
        }

        for (k = 0; k < copy.length; k++) {
            array[start + k] = copy[k];
        }

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(new InversePairs().InversePairs(array));
    }
}
