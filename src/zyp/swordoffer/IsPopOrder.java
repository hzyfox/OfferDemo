package zyp.swordoffer;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zyp
 */
public class IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
//       boolean flag = false;

        Stack<Integer> stackPush = new Stack<>();
        for(int i=0,j=0;i<pushA.length;i++){
            stackPush.push(pushA[i]);
           for(;j<popA.length&&!stackPush.isEmpty()&&stackPush.peek().equals(popA[j]);){
               stackPush.pop();
               j++;
           }
        }
        return stackPush.isEmpty() ;
    }

    public static void main(String[] args) {
        int[]a={1,2,3,4,5};
        int[]b={1,2,3,4,5};
        IsPopOrder isPopOrder = new IsPopOrder();
        System.out.println(isPopOrder.IsPopOrder(a,b));
    }
}
