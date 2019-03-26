package swordoffer;

import apple.laf.JRSUIUtils;
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

    public static void main(String[] args) {
        TreeNode root = Helper.stringToTreeNode("[1,2,3,4,5,#,#,#,#,6]","#");
        System.out.println(new BalancedSolution().IsBalanced_Solution(root));
    }
}
