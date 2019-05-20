package leetcode.util;

import leetcode.structure.TreeNode;

import java.util.*;

/**
 * create with leetcode.util
 * USER: husterfox
 */
public class Test {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return sb.toString();
        }
        queue.offer(root);
        boolean first = true;
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (!first) {
                sb.append(",");
            }
            first = false;
            if (t == null) {
                sb.append("#");
            } else {
                sb.append(t.val);
                queue.offer(t.left);
                queue.offer(t.right);
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        LinkedList<String> queue = new LinkedList<>();
        Collections.addAll(queue, data.split(","));
        TreeNode root = new TreeNode(Integer.valueOf(queue.poll()));
        LinkedList<TreeNode> queue0 = new LinkedList<>();
        queue0.offer(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue0.poll();

            //handle left
            if (!queue.isEmpty()) {
                String leftVal = queue.poll();
                if (leftVal.equals("#")) {
                    t.left = null;
                } else {
                    t.left = new TreeNode(Integer.valueOf(leftVal));
                }
            }
            if (!queue.isEmpty()) {
                String rightVal = queue.poll();
                if (rightVal.equals("#")) {
                    t.right = null;
                } else {
                    t.right = new TreeNode(Integer.valueOf(rightVal));
                }
            }

            if (t.left != null) {
                queue0.offer(t.left);
            }
            if (t.right != null) {
                queue0.offer(t.right);
            }
        }
        return root;
    }

    public void recoverTree(TreeNode root) {
        int find = 0;
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<TreeNode> nodes = new ArrayList<>();
        TreeNode t = root;
        while (t != null || !stack.isEmpty()) {
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
            TreeNode tmp = stack.pop();
            if (nodes.isEmpty()) {
                nodes.add(tmp);
            } else {
                if (tmp.val > nodes.get(nodes.size() - 1).val) {
                    nodes.add(tmp);
                } else {
                    for (TreeNode node : nodes) {
                        if (node.val > tmp.val) {
                            int tmpVal = tmp.val;
                            tmp.val = node.val;
                            node.val = tmp.val;
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) {


        ArrayList<TreeNode> arrayList = new ArrayList<>();
        TreeNode root = Helper.stringToTreeNode("[5,3,6,2,4,null,null,1]", "null");
        Test test = new Test();
        String str = test.serialize(root);
        test.deserialize(str);
    }
}
