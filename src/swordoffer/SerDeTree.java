package swordoffer;

import leetcode.structure.TreeNode;
import leetcode.util.Helper;

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

    String Serialize0(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return builder.toString();
        }
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode t = queue.poll();
            if(t == null){
                builder.append('#');
                builder.append(',');
            }else{
                builder.append(t.val);
                builder.append(',');
                queue.add(t.left);
                queue.add(t.right);
            }
        }
        builder.deleteCharAt(builder.length()-1);
        return builder.toString();
    }
    TreeNode Deserialize0(String str) {
        if(str.equals("")){
            return null;
        }
        String[] strs = str.split(",");
        LinkedList<TreeNode> queue = new LinkedList<>();
        int pos = 0;
        TreeNode root = new TreeNode(Integer.valueOf(strs[pos++]));
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode t = queue.poll();
            if(!strs[pos++].equals("#")){
                t.left = new TreeNode(Integer.valueOf(strs[pos-1]));
                queue.add(t.left);
            }
            if(!strs[pos++].equals("#")){
                t.right = new TreeNode(Integer.valueOf(strs[pos-1]));
                queue.add(t.right);
            }
        }
        return root;
    }


    public static void main(String[] args) {
        SerDeTree serDeTree = new SerDeTree();
        TreeNode root = Helper.stringToTreeNode("[5,4,#,3,#,2]","#");
        System.out.println(serDeTree.Serialize(root));
        System.out.println(serDeTree.Serialize(serDeTree.Deserialize(serDeTree.Serialize(root))));
    }
}
