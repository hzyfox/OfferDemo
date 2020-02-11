package zyp.swordoffer;

import zyp.structure.TreeNode;

/**
 * @author zyp
 */
public class Convert {
    TreeNode pre=null;
    TreeNode head = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return pRootOfTree;
        }
        Convert(pRootOfTree.left);
        pRootOfTree.left = pre;
        if(pre!=null){
            pre.right = pRootOfTree;
        }
        head = head==null?pRootOfTree:head;
        pre = pRootOfTree;
        Convert(pRootOfTree.right);
        return head;
    }



}
