package leetcode;

import leetcode.structure.TreeNode;

import java.util.LinkedList;
import java.util.List;
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
        inorder0(root, ans);
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

    public void inorder0(TreeNode root, List<Integer> ans) {
        //用于保存遍历过左子树的root
        List<TreeNode> visited = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            if (!visited.contains(root)) {
                visited.add(root);
                if (root.left != null) {
                    stack.push(root.left);
                    root = root.left;
                } else {
                    root = stack.pop();
                    ans.add(root.val);
                    if (root.right != null) {
                        stack.push(root.right);
                        root = root.right;
                    }
                }
            } else {
                //到这一步时，底下的左右子树已经遍历完了，需要再pop出来
                root = stack.pop();
                ans.add(root.val);
                if (root.right != null) {
                    stack.push(root.right);
                    root = root.right;
                }
            }
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
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new Solution94().inorderTraversal(root));
    }
}
