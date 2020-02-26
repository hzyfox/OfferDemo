package zyp.swordoffer;

import zyp.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zyp
 */
public class TreeSerialize {
    public static void main(String[] args) {
        TreeSerialize ts = new TreeSerialize();
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(6);
        node.right = new TreeNode(10);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(7);
        String x = ts.Serialize(node);
        System.out.println(x);
        TreeNode node1 = ts.Deserialize(x);
    }
    StringBuilder serialize = new StringBuilder();
    //层序遍历
    String Serialize(TreeNode root) {
        if(root==null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size()!=0){
            TreeNode tmp = queue.poll();
            if(tmp==null){
                serialize.append("#");
            }else {
                serialize.append(tmp.val);
                serialize.append("!");
            }
            if(tmp!=null){
                queue.offer(tmp.left);
                queue.offer(tmp.right);
            }
        }
        return serialize.toString();
    }


    TreeNode Deserialize(String str) {
        int i=0,j=i;
        TreeNode root=null;
        Queue<TreeNode> queue = new LinkedList<>();
        while (j<str.length()){
            TreeNode left=null;
            TreeNode right=null;
            if(str.charAt(j)=='#'){
                left = null;
            }else {
                while (str.charAt(j)!='!'){ j++;}
                left = new TreeNode(Integer.valueOf(str.substring(i,j)));
            }
            i=j+1;
            j=i;
            if(root==null){
                root=left;
                queue.add(root);
                continue;
            }
            if(str.charAt(j)=='#'){
                right=null;
            }else {
                while (str.charAt(j)!='!'){ j++;}
                right = new TreeNode(Integer.valueOf(str.substring(i,j)));
            }
            i=j+1;
            j=i;
        }
        return root;
    }
}
