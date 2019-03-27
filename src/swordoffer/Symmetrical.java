package swordoffer;

import leetcode.structure.TreeNode;
import leetcode.util.Helper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class Symmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return symmetrical(pRoot.left, pRoot.right);
    }

    public boolean symmetrical(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        }
        if (right == null) {
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return symmetrical(left.right, right.left) && symmetrical(left.left, right.right);
    }


    public static void main(String[] args) {
        TreeNode root = Helper.stringToTreeNode("[8,6,9,5,7,7,5]", "#");
        System.out.println(new Symmetrical().isSymmetrical(root));
    }
}
