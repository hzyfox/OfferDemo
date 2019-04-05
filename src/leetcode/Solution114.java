package leetcode;

import leetcode.structure.TreeNode;
import leetcode.util.Helper;

/**
 * create with leetcode
 * USER: husterfox
 */

public class Solution114 {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left==null){
            flatten(root.right);
        }else{
            if(root.left.left == null && root.left.right == null){
                TreeNode temp = root.right;
                root.right = root.left;
                TreeNode curr = root.right;
                TreeNode prev = root;
                while(curr!=null){
                    prev = curr;
                    curr = curr.right;
                }
                prev.right = temp;
                flatten(temp);
            }else{
                flatten(root.left);
                TreeNode temp = root.right;
                root.right = root.left;
                TreeNode curr = root.right;
                TreeNode prev = root;
                while(curr!=null){
                    prev = curr;
                    curr = curr.right;
                }
                prev.right = temp;
                flatten(temp);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = Helper.stringToTreeNode("[1,2,5,3,4,null,6]");
        new Solution114().flatten(root);
    }

}
