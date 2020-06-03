package Test;
import zyp.structure.TreeNode;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        Test t = new Test();
        char[][] board = {
                {'O','O','O','O','X','X'},
                {'O','O','O','O','O','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','X','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','O','O'}
        };
        int[] nums = {8,9,2,3,4};
        int[] gas = {1,2,3,4,3,2,4,1,5,3,2,4};
        int[] cost = {1,1,1,3,2,4,3,6,7,4,3,1};
        System.out.println(t.canCompleteCircuit(gas,cost));

        StringBuilder s = new StringBuilder();
        s.charAt()
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // int res = 0;
        if(gas.length <= 1){
            return 0;
        }
        help(gas,cost,0,0,0);
        if(start != Integer.MIN_VALUE){
            return start;
        }else{
            return -1;
        }
    }

    int start = Integer.MIN_VALUE;
    int flag = 0;
    //    int res = 0;
    public void help(int[] gas,int[] cost,int index,int res,int count){

        if(flag >= 2 * gas.length ){
            return;
        }

        if(index >= gas.length){
            index = 0;
        }

        if(count == gas.length){
            start = index;
            return;
        }

//        for(int i = index; i < gas.length; i++){
        flag++;
        if(res+gas[index] >= cost[index]){
            help(gas,cost,index+1,res+gas[index]-cost[index],count+1);
        }else{
            help(gas,cost,index+1,0,0);
        }
//        }
    }

}

