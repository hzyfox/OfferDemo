package leetcode;

import leetcode.structure.TreeNode;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class HasSubTree {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = DoesTree1HaveTree2(root1, root2);
            }
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    public boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null) return false;
        if (root2 == null) return true;
        if (root1.val != root2.val) return false;
        return DoesTree1HaveTree2(root1.left, root2.left) && DoesTree1HaveTree2(root1.right, root2.right);
    }
}
