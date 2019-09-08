package interview;

import leetcode.structure.TreeNode;

/**
 * 二叉搜索树的后继结点
 */
public class SuccNode {
    public TreeNode floor(TreeNode t, TreeNode target) {
        if (t == null) {
            return null;
        }
        if (target.val > t.val) {
            return floor(t.right, target);
        } else {
            if (target.val < t.val) {
                TreeNode tmp = floor(t.left, target);
                if (tmp == null) {
                    return t;
                } else {
                    return tmp;
                }
            } else {
                return t;
            }
        }
    }

    public TreeNode succ(TreeNode root, TreeNode target) {
        if (root == null) {
            return null;
        }
        if (target.val >= root.val) {
            return succ(root.right, target);
        } else {
            TreeNode tmp = succ(root.left, target);
            if (tmp == null) {
                return root;
            } else {
                return tmp;
            }
        }
    }

}
