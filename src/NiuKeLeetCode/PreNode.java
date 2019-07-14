package NiuKeLeetCode;

import leetcode.structure.TreeNode;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */
public class PreNode {
    public TreeNode ceil(TreeNode t, TreeNode target) {
        if (t == null) {
            return null;
        }
        if (target.val < t.val) {
            return ceil(t.left, target);
        } else {
            if (target.val > t.val) {
                TreeNode tmp = ceil(t.right, target);
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

    public TreeNode pre(TreeNode root, TreeNode target) {
        if (root == null) {
            return null;
        }
        if (target.val <= root.val) {
            return pre(root.left, target);
        } else {
            TreeNode tmp = pre(root.right, target);
            if (tmp == null) {
                return root;
            } else {
                return tmp;
            }
        }
    }
}
