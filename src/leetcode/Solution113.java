package leetcode;

import leetcode.structure.TreeNode;
import leetcode.util.Helper;

import java.util.ArrayList;
import java.util.List;

/**
 * create with leetcode
 * USER: husterfox
 */
public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> store = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        dfs(root, sum, store, ans, 0);
        return ans;
    }

    public void dfs(TreeNode root, int sum, ArrayList<Integer> store, List<List<Integer>> ans, int currSum) {
        store.add(root.val);
        currSum += root.val;
        if (root.left != null) {
            dfs(root.left, sum, store, ans, currSum);
        }
        if (root.right != null) {
            dfs(root.right, sum, store, ans, currSum);
        }
        if (root.left == null && root.right == null && currSum == sum) {
            ans.add((ArrayList<Integer>) store.clone());
        }
        store.remove(store.size() - 1);
    }


    public static void main(String[] args) {
        TreeNode root = Helper.stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,5,1]", "null");
        System.out.println(new Solution113().pathSum(root, 22));
    }
}
