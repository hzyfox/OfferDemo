package swordoffer;

import leetcode.structure.TreeNode;
import leetcode.util.Helper;

import java.util.ArrayList;
import java.util.Stack;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class FindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> store = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        find(root, target,  store, ans);
        return ans;
    }

    //dfs
    public void dfs(TreeNode root, ArrayList<Integer> store) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            store.add(t.val);
            if (t.right != null) {
                stack.push(t.right);
            }
            if (t.left != null) {
                stack.push(t.left);
            }
        }
    }
    //每次调用加的都需要在最后remove掉，这样每次到右节点的时候左节点的东西已经清楚干净了

    public void find(TreeNode root, int target, ArrayList<Integer> store, ArrayList<ArrayList<Integer>> ans) {
        store.add(root.val);

        if (root.left != null) {
            find(root.left, target, store, ans);
        }
        if (root.right != null) {
            find(root.right, target, store, ans);
        }
        if (root.left == null && root.right == null) {
            if (currSum(store) == target) {
                int i;
                for (i = 0; i < ans.size(); i++) {
                    if (store.size() <= ans.get(i).size()) {
                        break;
                    }
                }
                ans.add(i, (ArrayList<Integer>) store.clone());
            }
        }
        store.remove(store.size() - 1);
    }

    public int currSum(ArrayList<Integer> store) {
        int currSum = 0;
        for (Integer i : store) {
            currSum += i;
        }
        return currSum;
    }

    public static void main(String[] args) {
        TreeNode root = Helper.stringToTreeNode("[10,5,12,4,7]",null);
        ArrayList<Integer> store = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new FindPath().FindPath(root, 22);
        System.out.println(ans);

    }
}
