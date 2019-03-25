package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0){
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == 0) {
                    LinkedList<Integer> tmp = new LinkedList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[lo]);
                    tmp.add(nums[hi]);
                    result.add(tmp);
                    //应该等于0时 再去从  不能在else里面去重，否则可能会缺少解
                    //先lo++ hi-- 再去重， 防止lo hi多前进
                    lo++;
                    hi--;
                    while (lo < hi && nums[lo] == nums[lo - 1]) {
                        lo++;
                    }
                    while (lo < hi && nums[hi] == nums[hi + 1]) {
                        hi--;
                    }
                } else {
                    if (sum < 0) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }

        }
        return result;
    }
}
