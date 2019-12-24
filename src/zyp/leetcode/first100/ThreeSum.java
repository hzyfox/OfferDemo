package zyp.leetcode.first100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zyp
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
         for(int i=0;i<nums.length&&nums[i]<=0;i++){
             int target = 0-nums[i];
             int p = i+1,q=nums.length-1;
             while(p<q){
                 if(nums[p]+nums[q]>target){
                     q--;
                 }else if(nums[p]+nums[q]<target){
                     p++;
                 }else{
                     results.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[p],nums[q])));
                     while(p<q && nums[p] == nums[p+1]) p++;
                     while(p<q && nums[q] == nums[q-1]) q--;
                     p++;q--;
                 }
             }
             while (i < nums.length - 2 && nums[i] == nums[i+1]) {
                 i++;
             }
         }
         return  results;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        ThreeSum.threeSum(nums);
    }
}
