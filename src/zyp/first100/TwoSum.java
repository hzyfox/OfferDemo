package zyp.first100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyp
 */
public class TwoSum {

    public int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> results = new HashMap<Integer, Integer>();
        int[] index = new int[2];
        for (int i = 0; i<nums.length;i++){
            if(results.containsKey(nums[i])){
                index[0] = results.get(nums[i]);
                index[1] = i;
                break;
            }
            int tmp = target - nums[i];
            results.put(tmp,i);
        }
        return  index;
    }

}
