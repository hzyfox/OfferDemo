package swordoffer;

import leetcode.structure.TreeNode;
import leetcode.util.Helper;


import java.util.ArrayList;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class PrintLeft2Right {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<TreeNode> preNodes = new ArrayList<>();
        ArrayList<TreeNode> currNodes = new ArrayList<>();
        ArrayList<Integer> store = new ArrayList<>();

        if (pRoot == null) {
            return ans;
        }

        preNodes.add(pRoot);
        store.add(pRoot.val);
        ans.add((ArrayList<Integer>) store.clone());
        store.clear();

        while (!preNodes.isEmpty()) {
            for (int i = 0; i < preNodes.size(); i++) {
                if (preNodes.get(i).left != null) {
                    currNodes.add(preNodes.get(i).left);
                    store.add(preNodes.get(i).left.val);
                }
                if (preNodes.get(i).right != null) {
                    currNodes.add(preNodes.get(i).right);
                    store.add(preNodes.get(i).right.val);
                }
            }
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
        System.out.println(new PrintLeft2Right().Print(root));
    }
}
