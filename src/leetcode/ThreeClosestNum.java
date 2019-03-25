package leetcode;

import java.util.Arrays;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class ThreeClosestNum {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int distance = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == target) {
                    return target;
                } else {
                    //这里单独提出change， 因为result的判断会改变distance的值，所以不能将distance > Math.abs(sum - target)放到result判断
                    boolean change = distance > Math.abs(sum - target);
                    distance = change ? Math.abs(sum - target) : distance;
                    result = change ? sum : result;
                    if (sum < target) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return  result;
    }

}
