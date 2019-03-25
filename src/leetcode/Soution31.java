package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p>
 * The replacement must be in-place and use only constant extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * <p>
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Soution31 {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int i = nums.length - 2;
        int max = nums[nums.length - 1];
        boolean flag = false;
        while (i >= 0) {
            if (nums[i] < max) {
                flag = true;
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        break;
                    }
                }

                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[k] < nums[j]) {
                            int tmp = nums[k];
                            nums[k] = nums[j];
                            nums[j] = tmp;
                        }
                    }
                }
                break;
            } else {
                max = nums[i];
            }
            i--;
        }
        if(!flag){
            Arrays.sort(nums);
        }
    }
}
