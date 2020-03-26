package zyp.swordoffer;

import zyp.structure.TreeNode;

import java.util.*;

/**
 * @author zyp
 */
public class PrintZ {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot==null){
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        res.add(new ArrayList<>(Arrays.asList(pRoot.val)));
        int depth = 0;
        while (!queue.isEmpty()){
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int i=0;i<res.get(depth).size();i++){
                if(depth%2==0){
                    TreeNode node =  queue.removeFirst();
                    if(node.right!=null) {
                        queue.offer(node.right);
                        tmp.add(node.right.val);
                    }
                    if(node.left!=null){
                        queue.offer(node.left);
                        tmp.add(node.left.val);
                    }
                }else {
                    TreeNode node=queue.removeLast();
                    if(node.left!=null){
                        queue.offer(node.left);
                        tmp.add(node.left.val);
                    }
                    if(node.right!=null){
                        queue.offer(node.right);
                        tmp.add(node.right.val);
                    }
                }
            }
            res.add(tmp);
            depth++;
        }
        return res;
    }
}
