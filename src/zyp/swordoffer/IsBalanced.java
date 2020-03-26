package zyp.swordoffer;

import zyp.structure.TreeNode;

/**
 * @author zyp
 */
public class IsBalanced {
    Boolean flag = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null){
            return true;
        }
        adjustedHelper(root);
        return flag;
    }
    public int  adjustedHelper(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = adjustedHelper(root.left)+1;
        int right = adjustedHelper(root.right)+1;
        if(Math.abs(right-left)>1){
            flag = false;
        }
        return Math.max(left,right);
    }
}
