package zyp.swordoffer;

import zyp.structure.TreeNode;

import java.util.*;

/**
 * @author zyp
 */
public class FindPath {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> curPath = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        Find(root,target);
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.size()>o2.size()){
                    return 1;
                }else {
                    return -1;
                }
            }
        });
        return result;
    }
    public ArrayList<ArrayList<Integer>> Find(TreeNode root, int target) {
        if(root == null){
            return result;
        }
        curPath.add(root.val);
        target = target - root.val;
        if(root.left==null&&root.right==null&&target == 0){
                 result.add(new ArrayList<>(curPath));
         }
         FindPath(root.left,target);
         FindPath(root.right,target);
         curPath.remove(curPath.size()-1);
         return result;
    }




    public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root, int target) {
        curPath.add(root.val);
        target = target - root.val;
        if(root.left==null&&root.right==null){
            if(target == 0) {
                result.add(new ArrayList<>(curPath));
            }
        }
        if(root.left!=null){
            FindPath(root.left,target);
        }
        if(root.right!=null){
            FindPath(root.right,target);
        }
        curPath.remove(curPath.size()-1);
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        FindPath findPath  = new FindPath();
        findPath.FindPath2(root,7);
        for(int i =0;i<findPath.result.size();i++){
            System.out.println("///////////////");
            for(int j =0 ;j<findPath.result.get(i).size();j++){
                System.out.println(findPath.result.get(i).get(j));
            }
        }
    }
}
