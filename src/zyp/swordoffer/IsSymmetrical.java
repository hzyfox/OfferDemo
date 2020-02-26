package zyp.swordoffer;

import zyp.structure.TreeNode;

/**
 * @author zyp
 */
public class IsSymmetrical {
    boolean isSymmetrical(TreeNode pRoot)
    {
       if(pRoot==null){
           return true;
       }
       return helper(pRoot.left,pRoot.right);
    }

    public boolean helper(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        return (left.val==right.val)
                &&helper(left.left,right.right)
                &&helper(left.right,right.left);
    }
}
