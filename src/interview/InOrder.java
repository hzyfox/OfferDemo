package interview;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 二叉树中序遍历
 */
public class InOrder {
    public ArrayList<Integer> inOrder(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null || !stack.isEmpty()) {
           while(tmp!= null){
               stack.push(tmp);
               tmp = tmp.left;
           }
           tmp = stack.pop();
           ans.add(tmp.val);
           tmp = tmp.right;
        }
        return ans;
    }
}
