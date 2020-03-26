package zyp.swordoffer;

import zyp.structure.TreeNode;

/**
 * @author zyp
 */
public class ErChaShu {
    public  static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode treeNode =binaryTree(0,pre.length-1,0,in.length-1,pre,in);
        return treeNode;
    }

    public static TreeNode binaryTree(int preI,int preJ,int inI,int inJ,int []pre,int []in){
        if(preJ < preI){
            return null;
        }
        TreeNode treeNode =  new TreeNode(pre[preI]);
        if( preI == preJ){
            return treeNode;
        }

        int index = inI;
        while(index<inJ && pre[preI]!=in[index]){
            index++;
        }

        treeNode.left = binaryTree(preI+1,index-inI+preI,inI,index-1,pre,in);
        treeNode.right = binaryTree(index-inI+preI+1,preJ,index+1,inJ,pre,in);
        return  treeNode;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,3,4};
        int[] in = {1,2,3,4};

//        int[] pre={1,2,4,7,3,5,6,8};
//        int[] in={4,7,2,1,5,3,8,6};
        ErChaShu erChaShu = new ErChaShu();
        TreeNode treeNode=erChaShu.reConstructBinaryTree(pre,in);
       treeNode.layerPrint(treeNode);
    }
}
