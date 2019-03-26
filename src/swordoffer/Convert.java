package swordoffer;

import leetcode.structure.TreeNode;
import leetcode.util.Helper;


import java.util.Stack;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class Convert {
    //头和尾不相连
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        //这里不能提前在while循环前入栈 否则会造成第一个数重复入栈两次
        TreeNode t = pRootOfTree;
        TreeNode prev = null;
        TreeNode head = null;

        while (t != null || !stack.isEmpty()) {
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
            t = stack.pop();
            if (prev == null) {
                t.left = prev;
                head = t;
                prev = t;
            } else {
                prev.right = t;
                t.left = prev;
                prev = t;
            }
            t = t.right;
        }
        return head;
    }

    public static void main(String[] args) {
        TreeNode root = Helper.stringToTreeNode("[8,5,10,4,6,9,11]",null);
        root = new Convert().Convert(root);
        System.out.println(root);
    }


}
