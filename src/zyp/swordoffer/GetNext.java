package zyp.swordoffer;

import zyp.structure.TreeLinkNode;

/**
 * @author zyp
 */
public class GetNext {
    public static void main(String[] args) {
        TreeLinkNode node = new TreeLinkNode(8);
        node.left = new TreeLinkNode(6);
        node.right = new TreeLinkNode(10);
        node.left.next = node;
        node.right.next = node;
        node.left.left = new TreeLinkNode(5);
        node.left.right = new TreeLinkNode(7);
        node.left.left.next = node.left;
        node.left.right.next = node.left;
        node.right.left = new TreeLinkNode(9);
        node.right.right=new TreeLinkNode(11);
        node.right.left.next =  node.right;
        node.right.right.next = node.right;
        GetNext gn = new GetNext();
        gn.GetNext(node.left.right);
    }
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode.next==null&&pNode.right==null){
            return null;
        }
       else if(pNode.right==null&&pNode.next!=null){
            if(pNode.next.left==pNode){
                return pNode.next;
            }else {
                return getNextHelper(pNode);
            }
       }
       else {
            return gethelper(pNode.right);
        }
    }

    public TreeLinkNode getNextHelper(TreeLinkNode pNode){
        if(pNode.next!=null&&pNode.next.left==pNode){
            return pNode;
        }
        if(pNode.next!=null&&pNode.next.right==pNode){
            return getNextHelper(pNode.next);
        }else {
            return null;
        }
    }

    public TreeLinkNode gethelper(TreeLinkNode pNode){
        if(pNode.left==null&&pNode.right==null){
            return pNode;
        }
        if(pNode.left!=null){
            return gethelper(pNode.left);
        }else {
            return pNode;
        }
    }
}
