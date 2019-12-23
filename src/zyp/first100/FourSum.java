package zyp.first100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zyp
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums,target,4);

    }

    public List<List<Integer>> nSum(int[] nums, int target,int n) {
        List<List<Integer>> res = new LinkedList<>() ;

        if(n == 1){
            int i=0;
            for(int num:nums){
                if(num == target && !res.contains(new LinkedList<>(Arrays.asList(num)))) res.add(new LinkedList<>(Arrays.asList(num)));
            }
            return res;
        }
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());

        for(int i = 0;i<nums.length;i++){
            if(i>0 && nums[i] == nums[i-1]) { numsList.remove(0);continue;};
            int sum = target-nums[i];
            numsList.remove(0);
            List<List<Integer>> tmp = nSum(numsList.stream().mapToInt(Integer::valueOf).toArray(),sum,n-1);
            if(!tmp.isEmpty()) {for(List<Integer> list:tmp) list.add(nums[i]);if(res != tmp)res.addAll(tmp);};

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-5,-2,1,1,3,5,5,5};
        FourSum fourSum = new FourSum();
        List<List<Integer>> res = new LinkedList<>() ;
        res = fourSum.fourSum(nums,4);

        System.out.println(res.toString());
    }
}
