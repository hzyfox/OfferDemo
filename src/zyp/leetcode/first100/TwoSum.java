package zyp.leetcode.first100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyp
 */
public class TwoSum {
    public int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> res = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0;i<nums.length;i++){
            if(res.containsKey(target-nums[i])){
                result[0] = res.get(target-nums[i]);
                result[1] = i;
                break;
            }
            res.put(nums[i],i);
        }
        return result;
    }
}
