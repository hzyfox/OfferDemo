package zyp.swordoffer;

import zyp.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zyp
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(10);
//        root.left = new TreeNode(6);
//        root.right = new TreeNode(14);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(8);
//        root.right.left = new TreeNode(12);
//        root.right.right = new TreeNode(16);
        TreeNode root = null;
        PrintFromTopToBottom printFromTopToBottom = new PrintFromTopToBottom();
        ArrayList<Integer> list = printFromTopToBottom.PrintFromTopToBottom(root);
        System.out.println(list.isEmpty());
//        for(int x:list) {
//            System.out.println(x);
//        }
    }
}
