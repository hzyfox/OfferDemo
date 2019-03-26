package swordoffer;

import leetcode.structure.TreeNode;
import leetcode.util.Helper;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class TreeDepth {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
        }
    }

    public static void main(String[] args) {
        TreeNode root = Helper.stringToTreeNode("[1,2,4,3,null,null,null]",null);
        System.out.println(new TreeDepth().TreeDepth(root));
    }
}
