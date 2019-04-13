package swordoffer;


import leetcode.structure.TreeNode;
import leetcode.util.Helper;

import java.util.regex.Matcher;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class BalancedSolution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        return Math.abs(leftDepth - rightDepth) <= 1 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(treeDepth(root.left), treeDepth(root.right));
    }

    public boolean IsBalanced_Solution0(TreeNode root) {
        return getDepth(root) != -1;
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getDepth(root.right);
        if(right == -1){
            return -1;
        }
        return Math.abs(left-right) > 1 ? -1: 1+ Math.max(getDepth(root.left),getDepth(root.right));

    }

    public static void main(String[] args) {
        TreeNode root = Helper.stringToTreeNode("[1,2,3,4,5,#,#,#,#,6]", "#");
        System.out.println(new BalancedSolution().IsBalanced_Solution(root));
    }
}
