package leetcode;

import java.util.Stack;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class MyStack {
    public Stack<Integer> stack = new Stack<>();
    public Stack<Integer> minStack = new Stack<>();
    public int MIN = 0;
    public boolean flag = false;

    public void push(int node) {
        stack.push(node);
        if(!flag){
            MIN = node;
            minStack.push(node);
            flag = true;
        }else{
            if(node <= MIN){
                MIN = node;
                minStack.push(node);
            }
        }
    }
    public void pop() {
       int value = stack.pop();
       if(value == minStack.peek()){
           minStack.pop();
       }
    }
    public int top() {
        return stack.peek();
    }
    public int min() {
        return minStack.peek();
    }
}
