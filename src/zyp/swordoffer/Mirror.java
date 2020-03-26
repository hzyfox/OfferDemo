package zyp.swordoffer;

import zyp.structure.TreeNode;

/**
 * @author zyp
 */
public class Mirror {
    public void Mirror(TreeNode root) {
         TreeNode mirrorRoot = null;
         root = PreOrder(root,mirrorRoot);
         root.layerPrint(root);
    }

    public TreeNode PreOrder(TreeNode root,TreeNode mirrorRoot){
        if(root == null){
            return mirrorRoot;
        }
        mirrorRoot = new TreeNode(root.val);
        mirrorRoot.right = PreOrder(root.left,mirrorRoot.right);
        mirrorRoot.left = PreOrder(root.right,mirrorRoot.left);
        return mirrorRoot;
    }

    public static void main(String[] args) {
        int[] pre = {8,6,5,7,10,9,11};
        int[] in = {5,6,7,8,9,10,11};
        TreeNode root = ErChaShu.reConstructBinaryTree(pre,in);
        Mirror mirror = new Mirror();
        mirror.Mirror(root);
    }
}
