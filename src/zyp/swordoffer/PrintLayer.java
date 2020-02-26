package zyp.swordoffer;

import zyp.structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zyp
 */
public class PrintLayer {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(6);
        node.right = new TreeNode(10);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(7);
//        PrintLayer.Print(node);
    }
      ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        helper(pRoot,1,res);
        return res;
    }
    public  void helper(TreeNode root,int depth,ArrayList<ArrayList<Integer>> res){
        if(root==null){
            return;
        }
        if(depth>res.size()){
            res.add(new ArrayList<>());
        }
        res.get(depth-1).add(root.val);
        helper(root.left,depth+1,res);
        helper(root.right,depth+1,res);
    }
}
