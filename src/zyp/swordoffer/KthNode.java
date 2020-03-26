package zyp.swordoffer;

import zyp.structure.TreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zyp
 */
public class KthNode {
    public static void main(String[] args) {
        KthNode kthNode = new KthNode();
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(6);
        node.right = new TreeNode(10);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(7);
        node.right.left=new TreeNode(9);
        node.right.right = new TreeNode(11);
        kthNode.KthNode(node,3);
    }

    int count=0;
    TreeNode node = null;
    TreeNode KthNode(TreeNode pRoot,int k){
        if(pRoot==null||k<=0){
            return node;
        }
        KthNode(pRoot.left,k);
        count++;
        if(count==k){
            node = pRoot;
            return node;
        }
        return KthNode(pRoot.right,k);
    }


    TreeNode KthNode2(TreeNode pRoot, int k)
    {
        if(pRoot==null||k<=0){
            return null;
        }
        PriorityQueue<TreeNode> queue = new PriorityQueue<>(k, new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return o2.val-o1.val;
            }
        });
        KthNodeHelper(pRoot,k,queue);
        TreeNode res=null;
        for(int i = 0;i<queue.size();i++){
            if(i==queue.size()-k){
                res = queue.poll();
                break;
            }
            queue.poll();
        }
        return  res;
    }
    public void KthNodeHelper(TreeNode node,int k,PriorityQueue<TreeNode> queue){
        if(node==null){
            return;
        }
        if(queue.size()<k){
            queue.offer(node);
        }
        else if(queue.peek().val>node.val){
            queue.poll();
            queue.offer(node);
        }
        KthNodeHelper(node.left,k,queue);
        KthNodeHelper(node.right,k,queue);
    }
}
