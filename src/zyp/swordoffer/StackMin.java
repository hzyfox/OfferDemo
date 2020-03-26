package zyp.swordoffer;

import java.util.Stack;

/**
 * @author zyp
 */
public class StackMin {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public void push(int node) {
       stack.push(node);
       if(min.isEmpty()){
           min.push(node);
       }else{
           if(node <= min.peek()){
               min.push(node);
           }
       }
    }

    public void pop() {
       if(stack.peek().equals(min.peek())){
           stack.pop();
           min.pop();
       }else {
           stack.pop();
       }
    }

    public int top() {
      return stack.peek();
    }

    public int min() {
      return min.peek();
    }
}
