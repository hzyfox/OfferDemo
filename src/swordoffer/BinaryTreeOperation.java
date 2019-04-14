package swordoffer;

import leetcode.structure.TreeNode;
import leetcode.util.Helper;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class BinaryTreeOperation {
    //        5
    //     3       8
    //   1     6
    //     2     7
    public TreeNode createBinaryTree(int[] trees) {
        if (trees == null || trees.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(trees[0]);
        for (int i = 1; i < trees.length; i++) {
            put(root, trees[i]);
        }
        return root;
    }

    public TreeNode put(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (root.val > value) {
            root.left = put(root.left, value);
        } else {
            if (root.val < value) {
                root.right = put(root.right, value);
            } else {
                System.out.format("%d has exist in Tree", value);
            }
        }
        return root;
    }

    public TreeNode delete(TreeNode root, int value) {
        if (root == null) {
            return root;
        }
        if (root.val < value) {
            root.right = delete(root.right, value);
        } else {
            if (root.val > value) {
                root.left = delete(root.left, value);
            } else {
                //此时该节点就是要删除的节点
                TreeNode t = root;
                if (t.right == null) {
                    return t.left;
                }
                TreeNode x = minNode(root.right);
                TreeNode right = deleteMin(root.right);
                TreeNode left = t.left;
                t = x;
                t.right = right;
                t.left = left;
                return t;
            }
        }
        return root;
    }

    public TreeNode deleteMin(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root.right;
        }
        root.left = deleteMin(root.left);
        return root;
    }

    public TreeNode deleteMax(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return root.left;
        }
        root.right = deleteMax(root.right);
        return root;
    }

    public TreeNode minNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }
        return minNode(root.left);
    }

    public TreeNode maxNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return root;
        }
        return maxNode(root.right);
    }

    //所有<=root的最大值
    public TreeNode floor(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (target < root.val) {
            //如果target 小于root.val 则一定在左边
            return floor(root.left, target);
        } else {
            //如果target大于root，则可能在右边，也可能target是右边的最小值，如果不在右边，则一定在根节点
            if (target > root.val) {
                TreeNode right = floor(root.right, target);
                if (right == null) {
                    return root;
                } else {
                    return right;
                }
            } else {
                return root;
            }
        }
    }

    public TreeNode ceil(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (target > root.val) {
            return floor(root.right, target);
        } else {
            if (target < root.val) {
                TreeNode left = floor(root.left, target);
                if (left == null) {
                    return root;
                } else {
                    return left;
                }
            } else {
                return root;
            }
        }
    }

    public static void main(String[] args) {
        int[] trees = {5, 3, 8, 1, 2, 6, 7};
        BinaryTreeOperation binaryTreeOperation = new BinaryTreeOperation();
        TreeNode root = binaryTreeOperation.createBinaryTree(trees);
        System.out.println("trees: " + Helper.intArrayToString(trees));
        System.out.println("buildTree: " + Helper.treeNodeToString(root));
        root = binaryTreeOperation.delete(root, 5);
        System.out.println("delete 5: " + Helper.treeNodeToString(root));
    }
}
