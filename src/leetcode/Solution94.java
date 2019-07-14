package leetcode;

import leetcode.structure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        //  inorder(root, ans);
        inorder1(root, ans);
        return ans;

    }

    public void inorder(TreeNode root, List<Integer> ans) {
        if (root.left != null) {
            inorder(root.left, ans);
        }
        ans.add(root.val);
        if (root.right != null) {
            inorder(root.right, ans);
        }
    }

    public void preOrder(TreeNode root, List<Integer> ans) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            ans.add(tmp.val);
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
        }
    }

    public void postOrder(TreeNode root, List<Integer> ans) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }
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
    }


    public void inorder1(TreeNode root, List<Integer> l) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode t = root;
        while (t != null || !s.isEmpty()) {
            while (t != null) {
                s.push(t);
                t = t.left;
            }
            t = s.pop();
            l.add(t.val);
            t = t.right;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> bigHeap = new PriorityQueue<>((a, b) -> a-b);
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new Solution94().inorderTraversal(root));
    }
}
