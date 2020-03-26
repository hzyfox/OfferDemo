package zyp.swordoffer;

import zyp.structure.TreeNode;

import java.util.ArrayList;

/**
 * @author zyp
 */
public class TreeDepth {
    ArrayList<Integer> curPath = new ArrayList<>();
    int depth = 0;
    public int TreeDepth(TreeNode root) {
        if(root==null){
            depth = depth>=curPath.size()?depth:curPath.size();
            return depth;
        }
        curPath.add(root.val);
        TreeDepth(root.left);
        TreeDepth(root.right);
        curPath.remove(curPath.size()-1);
        return depth;
    }
    public int TreeDepth2(TreeNode root){
        if(root==null){
            return  0 ;
        }
        return Math.max(TreeDepth2(root.left),TreeDepth2(root.right))+1;
    }

}
