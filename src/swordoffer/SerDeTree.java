package swordoffer;

import leetcode.structure.TreeNode;

import java.util.LinkedList;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class SerDeTree {
    public String Serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            builder.append("#");
            builder.append("]");
            return builder.toString();
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t == null) {
                builder.append("#");
                builder.append(",");
            } else {
                builder.append(t.val);
                builder.append(",");
                queue.offer(t.left);
                queue.offer(t.right);
            }

        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }

    //[1,#,2,3]
    public TreeNode Deserialize(String str) {
        str = str.trim();
        str = str.substring(1, str.length() - 1);
        String[] splits = str.split(",");
        TreeNode root = null;
        int i = 0;
        if ("#".equals(splits[i])) {
            return null;
        } else {
            root = new TreeNode(Integer.valueOf(splits[i]));
        }
        i++;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty() && i < splits.length) {
            TreeNode node = queue.poll();
            if (!"#".equals(splits[i])) {
                node.left = new TreeNode(Integer.valueOf(splits[i]));
                queue.add(node.left);
            }
            i++;
            if (!"#".equals(splits[i])) {
                node.right = new TreeNode(Integer.valueOf(splits[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new SerDeTree().Deserialize("[1,2,2,3,4,#,#,#,#,#,#]");
        System.out.println(root);
        System.out.println(new SerDeTree().Serialize(root));
    }
}
