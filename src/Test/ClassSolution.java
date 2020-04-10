
package Test;
import zyp.structure.TreeNode;

import java.util.*;


class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
//        root.left.left.left  = new TreeNode(3);
        Solution s = new Solution();
        System.out.println(s.pathSum(root,3));
    }



        int res = 0;
        public int pathSum(TreeNode root, int sum) {
            List<Integer> path = new LinkedList<>();
            dp(root,sum,root.val,false,path);
            return res;
        }

        public void dp(TreeNode root,int sum,int cur,boolean disguard,List<Integer> path){
            if(cur==sum){
                res++;
                //  System.out.println("!!!!!!!!!");
                // for(int x:path){

                //     System.out.println(x);
                // }
            }

            if(root==null){
                return;
            }
            // cur = disguard==true?0:cur;

            //不加上当前值
            if(root.left!=null)
            {
                dp(root.left,sum,root.left.val,true,path);
                // path.add(root.val);
                dp(root.left,sum,cur+root.left.val,false,path);
                // path.remove(path.size()-1);
            }

            if(root.right!=null)
            {
                dp(root.right,sum,root.right.val,true,path);
                // path.add(root.val);
                dp(root.right,sum,cur+root.right.val,false,path);
                // path.remove(path.size()-1);
            }
        }

}