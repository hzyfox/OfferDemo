package zyp.leetcode.first100;

import java.util.*;

/**
 * @author zyp
 */
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        int[] num = {0,0,0};
        List<List<Integer>> res=t.threeSum(num);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length-2; i++) {
            if(i>0&&nums[i]==nums[i-1]) {
                continue;
            }
            if(nums[i]>0){
                break;
            }
            int l = i+1,r = nums.length-1,target = 0-nums[i];
            while (l<r){
                if(nums[l]+nums[r]==target){
                    res.add(new LinkedList<>(Arrays.asList(nums[i],nums[l],nums[r])));
                    while (l<r&&nums[l]==nums[l+1]){
                        l++;
                    }
                    l++;
                    while (l<r&&nums[r] == nums[r-1]){
                        r--;
                    }
                    r--;
                }else if(nums[l]+nums[r]>target){
                    r--;
                }else {
                    l++;
                }
            }

        }
        return res;
    }
}
