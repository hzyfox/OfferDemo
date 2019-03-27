package swordoffer;

import leetcode.structure.TreeLinkNode;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        //如果该节点为根节点
        if (pNode.next == null) {
            if (pNode.right == null) {
                return null;
            } else {
                TreeLinkNode right = pNode.right;
                while (right.left != null) {
                    right = right.left;
                }
                return right;
            }
        }

        //如果该树是右孩子，且其有右子树
        if (pNode.next.right == pNode && pNode.right != null) {
            TreeLinkNode right = pNode.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;
        }

        //如果该树是右孩子且其无右子树，则一直往上找父母，直到找到父母是左孩子
        if (pNode.next.right == pNode && pNode.right == null) {
            TreeLinkNode parent = pNode.next;
            TreeLinkNode prev = pNode;
            while (parent.next != null && parent.next.left != parent) {
                prev = parent;
                parent = parent.next;
            }
            //说明是最右节点，没有后面的
            if (parent.next == null && parent.right == prev) {
                return null;
            }
            //说明该节点在根节点的左边,直接返回根节点
            if (parent.next == null && parent.left == prev) {
                return parent;
            }
            //说明还没到根节点就找符合条件的值了,直接返回该节点
            return parent.next;
        }

        //如果该树是左孩子
        if (pNode.next.left == pNode) {
            if (pNode.right != null) {
                TreeLinkNode right = pNode.right;
                while (right.left != null) {
                    right = right.left;
                }
                return right;
            } else {
                //如果左孩子没有右子树
                return pNode.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
