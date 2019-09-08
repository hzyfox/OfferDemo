package interview;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 前序遍历
 */
public class PreOrder {
    public ArrayList<Integer>  preOrder(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            if(tmp.right != null){
                stack.push(tmp.right);
            }
            if(tmp.left != null){
                stack.push(tmp.right);
            }
            ans.add(tmp.val);
        }
        return ans;
    }
}
