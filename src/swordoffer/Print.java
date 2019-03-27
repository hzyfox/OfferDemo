package swordoffer;

import leetcode.structure.TreeNode;
import leetcode.util.Helper;

import java.util.ArrayList;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class Print {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> store = new ArrayList<>();
        ArrayList<TreeNode> preNodes = new ArrayList<>();
        ArrayList<TreeNode> currNodes = new ArrayList<>();
        if (pRoot == null) {
            return ans;
        }
        store.add(pRoot.val);
        preNodes.add(pRoot);
        ans.add((ArrayList<Integer>) store.clone());
        int right2left = 1;
        store.clear();
        while (preNodes.size() != 0) {
            for (int i = preNodes.size() - 1; i >= 0; i--) {
                if ((right2left & 1) == 1) {
                    if (preNodes.get(i).right != null) {
                        store.add(preNodes.get(i).right.val);
                        currNodes.add(preNodes.get(i).right);
                    }
                    if (preNodes.get(i).left != null) {
                        store.add(preNodes.get(i).left.val);
                        currNodes.add(preNodes.get(i).left);
                    }
                } else {
                    if (preNodes.get(i).left != null) {
                        store.add(preNodes.get(i).left.val);
                        currNodes.add(preNodes.get(i).left);
                    }
                    if (preNodes.get(i).right != null) {
                        store.add(preNodes.get(i).right.val);
                        currNodes.add(preNodes.get(i).right);
                    }
                }
            }
            right2left++;
            if (!store.isEmpty()) {
                ans.add((ArrayList<Integer>) store.clone());
            }
            store.clear();
            ArrayList<TreeNode> tmp = preNodes;
            preNodes = currNodes;
            currNodes = tmp;
            currNodes.clear();
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = Helper.stringToTreeNode("[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]");
        System.out.println(new Print().Print(root));
    }
}
