package interview;


import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 二叉树层次遍历
 */
public class HierarchicalTraversal {
    public ArrayList<Integer> levelOrder(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode t = queue.poll();
            if(t.left != null){
                queue.add(t.left);
            }
            if(t.right != null){
                queue.add(t.right);
            }
            ans.add(t.val);
        }
        return ans;
    }
}
