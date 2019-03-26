package swordoffer;

import leetcode.structure.TreeNode;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class ConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        if (pre.length == 1) {
            return root;
        }
        int i = 0;
        for (; i < in.length; i++) {
            if (pre[0] == in[i]) {
                break;
            }
        }
        int[] leftPre = new int[i];
        int[] leftIn = new int[i];
        System.arraycopy(pre, 1, leftPre, 0, i);
        System.arraycopy(in, 0, leftIn, 0, i);
        int[] rightPre = new int[pre.length - 1 - i];
        int[] rightIn = new int[rightPre.length];
        System.arraycopy(pre, i + 1, rightPre, 0, rightPre.length);
        System.arraycopy(in, i + 1, rightIn, 0, rightPre.length);
        root.left = reConstructBinaryTree(leftPre, leftIn);
        root.right = reConstructBinaryTree(rightPre, rightIn);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode t = new ConstructBinaryTree().reConstructBinaryTree(pre, in);
        System.out.println(t);
    }
}
