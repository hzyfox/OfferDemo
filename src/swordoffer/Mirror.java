package swordoffer;


import leetcode.structure.TreeNode;
import leetcode.util.Helper;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class Mirror {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        bfs(root);
    }

    public void bfs(TreeNode root) {
        if(root.left == null && root.right == null){
            return;
        }
        if (root.left == null) {
            root.left = root.right;
            root.right = null;
            bfs(root.left);
        } else {
            if (root.right == null) {
                root.right = root.left;
                root.left = null;
                bfs(root.right);
            } else {
                TreeNode tmp = root.left;
                root.left = root.right;
                root.right = tmp;
                bfs(root.left);
                bfs(root.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = Helper.stringToTreeNode("[8,null,7,null,6,null,5,null,4]",null);
        new Mirror().Mirror(root);
        System.out.println(root);
    }
}
