package swordoffer;

import leetcode.structure.TreeNode;
import leetcode.util.Helper;

import java.util.ArrayList;
import java.util.LinkedList;

public class PrintFromTopToBtoom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        } else {
            bfs(root, ans);
            return ans;
        }

    }

    public void printRecursion(TreeNode root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        } else {
            ans.add(root.val);
        }

        if (root.left != null) {
            printRecursion(root, ans);
        }
    }

    public void bfs(TreeNode root, ArrayList<Integer> ans) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            ans.add(t.val);
            if (t.left != null) {
                queue.offer(t.left);
            }
            if (t.right != null) {
                queue.offer(t.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = Helper.stringToTreeNode("[10,6,14,4,8,12,16]");
        System.out.println(new PrintFromTopToBtoom().PrintFromTopToBottom(root));
    }

}
