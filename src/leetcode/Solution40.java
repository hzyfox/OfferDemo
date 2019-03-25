package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Solution40 {
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> store = new LinkedList<>();
        dfs(store, target, 0, candidates);
        return result;
    }

    public void dfs(LinkedList<Integer> store, int target, int start, int[] candidates) {
        if (target == 0) {
            result.add((LinkedList<Integer>) store.clone());
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            store.add(candidates[i]);
            dfs(store, target - candidates[i], i + 1, candidates);
            int prev = store.remove(store.size() - 1);
            while (i+1 < candidates.length && candidates[i + 1] == prev) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {2,5,2,1,2};
        System.out.println(new Solution40().combinationSum2(test, 5));
    }
}
