package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Solution46 {
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> store = new LinkedList<>();
        dfs(nums, nums.length, store);
        return result;
    }

    public void dfs(int[] nums, int leftNumber, LinkedList<Integer> store) {
        if (leftNumber == 0) {
            result.add((LinkedList<Integer>) store.clone());
            return;
        }
        for (int num : nums) {
            if (!store.contains(num)) {
                store.add(num);
                dfs(nums, leftNumber - 1, store);
                store.remove(store.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3};
        System.out.println(new Solution46().permute(test));
    }
}
