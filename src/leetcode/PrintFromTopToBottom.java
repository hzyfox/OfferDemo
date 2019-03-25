package leetcode;

import leetcode.structure.TreeNode;
import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();
        if (root == null) {
            return arrayList;
        } else {
            linkedList.offer(root);
            while (!linkedList.isEmpty()) {
                TreeNode node = linkedList.poll();
                arrayList.add(node.val);
                if (node.left != null) {
                    linkedList.offer(node.left);
                }
                if (node.right != null) {
                    linkedList.offer(node.right);
                }
            }

        }
        return arrayList;
    }



    @Contract("true->fail")
    private static boolean test(boolean flag){
        if(flag){
            System.exit(1);
        }
        return false;
    }
}
