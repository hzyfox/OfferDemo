package zyp.swordoffer;

import zyp.structure.TreeNode;

import java.util.ArrayList;

/**
 * @author zyp
 */
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        Boolean result = false;
        if(root1!= null && root2!=null){
            if(root1.val == root2.val){
                result = IsSubtree(root1,root2);
            }
            if(!result){
                result = HasSubtree(root1.left,root2);
            }
            if(!result){
                result = HasSubtree(root1.right,root2);
            }
        }
        return result;
    }

    public boolean IsSubtree(TreeNode root1,TreeNode root2){
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return  false;
        }

        if(root1.val!=root2.val){
            return false;
        }

        return IsSubtree(root1.left,root2.left) && IsSubtree(root1.right,root2.right);

    }



}
