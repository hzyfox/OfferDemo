package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Solution39 {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new LinkedList<List<Integer>>();
        ArrayList<Integer> store = new ArrayList<Integer>();
        dfs(store, candidates, target, 0);
        return this.res;
    }
    public void dfs(ArrayList<Integer> store, int[] candidates, int target, int star){
        if(target==0) {
            this.res.add((List<Integer>) store.clone());
            return;
        }
        if(target<0) {
            return;
        }
        for(int i = star; i<candidates.length; ++i){
            store.add(candidates[i]);
            dfs(store, candidates, target-candidates[i], i);
            store.remove(store.size()-1);
        }
    }

}
