package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class FourSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 2, -5, 0, -1, 4};
        System.out.println(new FourSum().fourSum(nums, 3));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int lo = j + 1;
                int hi = nums.length - 1;
                while (lo < hi) {
                    if (nums[i] + nums[j] + nums[lo] + nums[hi] == target) {
                        LinkedList<Integer> tmp = new LinkedList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[lo]);
                        tmp.add(nums[hi]);
                        result.add(tmp);
                        //lo++ hi-- while一定要放在前面，放在后面会造成多减了一次
                        lo++;
                        hi--;
                        while (lo < hi && nums[lo - 1] == nums[lo]) {
                            lo++;
                        }
                        while (hi > lo && nums[hi + 1] == nums[hi]) {
                            hi--;
                        }
                    } else {
                        if (nums[i] + nums[j] + nums[lo] + nums[hi] < target) {
                            lo++;
                        } else {
                            hi--;
                        }
                    }
                }
                while (j + 1 < nums.length - 2 && nums[j + 1] == nums[j]) {
                    j++;
                }
            }
            while (i + 1 < nums.length - 3 && nums[i + 1] == nums[i]) {
                i++;
            }
        }
        return result;
    }
}

