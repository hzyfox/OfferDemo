package swordoffer;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class SortedArray {
    public static int findTruningPoint(int[] store) {
        int start = 0;
        int end = store.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (store[mid] <= store[start] && store[mid] <= store[end]) {
                return mid;
            }
            if (store[mid] > store[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int findTargetInRepeatedSortedArray(int[] store, int target) {
        int start = 0;
        int end = store.length - 1;
        int lowBound = -1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (store[mid] < target) {
                start = mid + 1;
            } else {
                if (store[mid] >= target) {
                    end = mid - 1;
                }
            }
        }
        lowBound = start;
        int highBound = -1;
        start = 0;
        end = store.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (store[mid] < target + 1) {
                start = mid + 1;
            } else {
                if (store[mid] >= target + 1) {
                    end = mid - 1;
                }
            }
        }
        highBound = start;
        return lowBound == -1 && highBound == -1 ? -1 : highBound - lowBound + 1;
    }

    public static void main(String[] args) {
        int[] store = {1, 2, 2, 2, 2, 2,3};
        System.out.println(SortedArray.findTargetInRepeatedSortedArray(store, 2));
    }
}
