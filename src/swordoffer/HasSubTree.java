package swordoffer;

import leetcode.structure.TreeNode;
import leetcode.util.Helper;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class HasSubTree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        return root2 != null && root1 != null && judge(root1, root2);
    }

    public boolean judge(TreeNode root1, TreeNode root2) {
        return subTree(root1, root2) || subTree(root1.left, root2) || subTree(root1.right, root2);
    }

    public boolean subTree(TreeNode root1, TreeNode root2) {
        return root2 == null || root1 != null && root1.val == root2.val && subTree(root1.left, root2.left) && subTree(root1.right, root2.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = Helper.stringToTreeNode("[8,8,null,9,null,2,null,5]");
        TreeNode root2 = Helper.stringToTreeNode("[8,9,null,3]");
        System.out.println(new HasSubTree().HasSubtree(root1, root2));
    }
}
