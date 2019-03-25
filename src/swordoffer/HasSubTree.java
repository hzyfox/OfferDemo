package swordoffer;

import leetcode.structure.TreeNode;
import leetcode.util.Helper;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class HasSubTree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null || root1 == null) {
            return false;
        }
        return judge(root1, root2);
    }

    public boolean judge(TreeNode root1, TreeNode root2) {

    }

    public static void main(String[] args) {
        TreeNode root1 = Helper.stringToTreeNode("[8,8,null,9,null,2,null,5]");
        TreeNode root2 = Helper.stringToTreeNode("[8,9,null,2]");
        System.out.println(new HasSubTree().HasSubtree(root1, root2));
    }
}
