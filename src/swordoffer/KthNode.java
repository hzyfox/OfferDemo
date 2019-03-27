package swordoffer;

import leetcode.structure.TreeNode;

import java.util.Stack;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class KthNode {
    public TreeNode KthNode(TreeNode pRoot, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        TreeNode t = pRoot;
        while (t != null || !stack.isEmpty()) {
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
            t = stack.pop();
            i++;
            if (i == k) {
                return t;
            }
            t = t.right;
        }
        return null;
    }
}
