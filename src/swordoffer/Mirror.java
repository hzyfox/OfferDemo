package swordoffer;


import leetcode.structure.TreeNode;
import leetcode.util.Helper;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class Mirror {
    public void Mirror(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = Helper.stringToTreeNode("[8,null,7,null,6,null,5,null,4]", null);
        new Mirror().Mirror(root);
        System.out.println(root);
    }
}
