package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
       // LinkedList<Integer> store = new LinkedList<>();

        for (int i = 1; i <= nums.length; i++) {
            LinkedList<Integer> store = new LinkedList<>();
            dfs(i, store, 0, result, nums);
        }
        result.add(new ArrayList<>());

        return result;
    }

    public void dfs(int k, LinkedList<Integer> store, int pos, List<List<Integer>> result, int[] nums) {
        if (store.size() == k) {
            result.add((LinkedList<Integer>) store.clone());
            return;
        }
        final int leftNumber = k - store.size();
        for (int i = pos; i < nums.length && nums.length - pos >= leftNumber; i++) {
            store.add(nums[i]);
            dfs(k, store, i + 1, result, nums);
            store.remove(store.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3};
        System.out.println(new Solution78().subsets(array));
    }


}
