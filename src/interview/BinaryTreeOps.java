package interview;

import leetcode.structure.TreeNode;

/**
 * 二叉搜索树操作
 */
public class BinaryTreeOps {
    public TreeNode deleteMin(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root.right;
        }
        root.left = deleteMin(root.left);
        return root;
    }

    public TreeNode deleteMax(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return root.left;
        }
        root.right = deleteMax(root.right);
        return root;
    }

    public TreeNode delete(TreeNode root, TreeNode target){
        if(root == null){
            return null;
        }
        if(target.val < root.val){
            root.left = delete(root.left, target);
        }else{
            if(target.val > root.val){
                root.right = delete(root.right, target);
            }else{
                if(root.right == null){
                    return root.left;
                }
                TreeNode min = findMinNode(root.right);
                TreeNode rightRoot = deleteMin(root.right);
                min.left = root.left;
                min.right = rightRoot;
                return min;
            }
        }
        return root;
    }

    public TreeNode findMinNode(TreeNode root){
        if(root == null){
            return null;
        }
        if(root.left == null){
            return root;
        }else{
            return findMinNode(root.left);
        }
    }
}
