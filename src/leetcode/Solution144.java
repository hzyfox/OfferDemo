package leetcode;

import leetcode.structure.TreeNode;

import java.util.*;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        postorder(root, ans);
        return ans;
    }

    public void preorder(TreeNode root, List<Integer> ans) {
        ans.add(root.val);
        if (root.left != null) {
            preorder(root.left, ans);
        }
        if (root.right != null) {
            preorder(root.right, ans);
        }
    }

    public void preorder0(TreeNode root, List<Integer> ans) {
        ArrayList<TreeNode> visited = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.peek();
            if (!visited.contains(root)) {
                ans.add(root.val);
                visited.add(root);

                if (root.left != null) {
                    stack.add(root.left);
                } else {
                    if (root.right != null) {
                        stack.add(root.right);
                    } else {
                        stack.pop();
                    }
                }
            } else {
                root = stack.pop();
                if (root.right != null) {
                    stack.add(root.right);
                }
            }
        }
    }

    public void preOrder(TreeNode root, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                list.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
    }

    public void postorder(TreeNode root, List<Integer> ans) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        if (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            //每次往前插，入栈顺序是根右左，所以出栈顺序是左右根 符合要求
            ans.add(0, node.val);
        }
    }

    public void inorder(TreeNode root, List<Integer> ans) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            ans.add(node.val);
            node = node.right;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new Solution144().preorderTraversal(root));
    }
}
