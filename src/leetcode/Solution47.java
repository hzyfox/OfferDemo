package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Solution47 {
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> store = new LinkedList<>();
        LinkedList<Integer> index = new LinkedList<>();
        dfs(nums, nums.length, store, index);
        return result;
    }

    public void dfs(int[] nums, int leftNumber, LinkedList<Integer> store, LinkedList<Integer> index) {
        if (leftNumber == 0) {
            result.add((LinkedList<Integer>) store.clone());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!index.contains(i)) {
                store.add(nums[i]);
                index.add(i);
                dfs(nums, leftNumber - 1, store, index);
                store.remove(store.size() - 1);
                index.remove(index.size() - 1);
                while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {1,1,2};
        System.out.println(new Solution47().permuteUnique(test));
    }
}
