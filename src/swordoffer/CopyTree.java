package swordoffer;

import leetcode.structure.TreeNode;

import java.util.LinkedList;

public class CopyTree {
    public TreeNode copyTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode head = new TreeNode(root.val);
        LinkedList<TreeNode> helperQueue = new LinkedList<>();
        queue.offer(root);
        helperQueue.offer(head);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            TreeNode copy = helperQueue.poll();
            if (tmp.left != null) {
                queue.offer(tmp.left);
                copy.left = tmp.left;
                helperQueue.offer(copy.left);
            }
            if (tmp.right != null) {
                queue.offer(tmp.right);
                copy.right = tmp.right;
                helperQueue.offer(copy.right);
            }
        }
        return head;
    }
}
