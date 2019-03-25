package leetcode;

import java.util.Stack;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class TwoStackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int node) {
        if(!stack1.empty()){
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            stack2.push(node);
            while(!stack2.empty()){
                stack1.push(stack2.pop());
            }
        }else{
            while(!stack2.empty()){
                stack1.push(stack2.pop());
            }
            stack1.push(node);
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
    }
    public int pop() {
        if(!stack1.empty()){
            return stack1.pop();
        }else{
           return  stack2.pop();
        }
    }
}
