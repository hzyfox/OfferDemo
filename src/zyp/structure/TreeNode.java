package zyp.structure;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zyp
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {val = x;}

    public void layerPrint(TreeNode treeNode){
        Queue<TreeNode>  queue = new ArrayDeque<>();
        queue.add(treeNode);
        while(!queue.isEmpty()){
            TreeNode tn = queue.poll();
            System.out.println(tn.val);
            if(tn.left!=null) queue.add(tn.left);
            if(tn.right!=null) queue.add(tn.right);
        }
    }
}
