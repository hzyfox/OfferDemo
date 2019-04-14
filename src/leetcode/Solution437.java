package leetcode;

import leetcode.structure.TreeNode;
import leetcode.util.Helper;

public class Solution437 {
    int cnt =0;
    public int pathSum(TreeNode root, int sum) {
        sum(root, 0, sum);
        return cnt;
    }
    public void sum(TreeNode root, int sum, int target){
        if(root == null){
            return;
        }
        path(root, sum , target);
        sum(root.left, sum, target);
        sum(root.right, sum, target);
    }
    public void path(TreeNode root, int sum, int target){
        if(root == null){
            return;
        }
        sum += root.val;
        if(sum == target){
            cnt++;
        }
        path(root.left, sum, target);
        path(root.right,sum,target);
    }

    public static void main(String[] args) {
        TreeNode root = Helper.stringToTreeNode("[1,null,2,null,3]");
        System.out.println(new Solution437().pathSum(root,3));
    }
}
