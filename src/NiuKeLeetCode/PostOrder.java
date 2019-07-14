package NiuKeLeetCode;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */
public class PostOrder {
    public ArrayList<Integer> postOrder(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            ans.add(0, tmp.val);
        }
        return ans;
    }
}
