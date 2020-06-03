
package Test;
import zyp.structure.TreeNode;

import java.util.*;


class Solution {
    public static void main(String[] args) {


        Solution s = new Solution();
        int[] nums = {1,1,1,2,3};
        s.removeDuplicates(nums);

    }



    public int removeDuplicates(int[] nums) {
        // int count = 1;
        int length = nums.length;
        int j = nums.length-1;
        for(int i = nums.length-2; i >= 0;){
            if(nums[i] != nums[i+1]){
                j = i;
                i--;
                continue;
            }
            while(i >=0 && nums[i] == nums[i+1]){
                i--;
            }
            int start = i+1;
            int end = j;
            if(end - start + 1 > 2){
                help(nums,start,end-1);
                length = length - (end-start-1);
            }
            j = i;
        }
        return length;
    }

    public void help(int[] nums,int start,int end){
        for(int i = end; i < nums.length; i++){
            nums[start++] = nums[i];
        }
    }
}