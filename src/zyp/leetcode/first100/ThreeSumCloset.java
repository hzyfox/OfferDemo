package zyp.leetcode.first100;

import java.util.Arrays;

/**
 * @author zyp
 */
public class ThreeSumCloset {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int tmp = 0;
        for(int i=0;i<nums.length;i++){
           int p=i+1,q=nums.length-1;
           int sum = target - nums[i];
           while(p<q) {
               if(Math.abs(sum - (nums[p] + nums[q])) < min) {
                   min = Math.abs(sum - (nums[p] + nums[q]));
                   tmp = sum - (nums[p] + nums[q]);
               }
               if (min == 0) {
                   return target;
               }
               if (nums[p] + nums[q] > sum) q--;
               else if (nums[p] + nums[q] < sum) p++;
               else {
                   p++;
                   q--;
               }

           }
        }
        return  (target-tmp);
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2};
        int x= ThreeSumCloset.threeSumClosest(nums,3);
        System.out.println(x);
    }
}
