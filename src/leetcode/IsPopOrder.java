package leetcode;

import java.util.Stack;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class IsPopOrder {
    Stack<Integer> stack = new Stack<>();
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int j=0;
        for(int i = 0; i<pushA.length; i++){
            if(pushA[i] == popA[j]){
                j++;
            }else {
                if (stack.size()!=0 && stack.peek() == popA[j]){
                    stack.pop();
                    j++;
                    i--;
                }else{
                    stack.push(pushA[i]);
                }
            }
        }
        while(!stack.empty()){
            if(stack.pop() != popA[j++]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushA = new int[]{1,2,3,4,5};
        int[] popA = new int[]{4,5,3,2,1};
        System.out.println(new IsPopOrder().IsPopOrder(pushA,popA));
    }
}
