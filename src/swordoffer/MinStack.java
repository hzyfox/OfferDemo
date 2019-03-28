package swordoffer;

import java.util.Arrays;
import java.util.Stack;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class MinStack {

    private int size;
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> minStack = new Stack<Integer>();
    private Integer[] elements = new Integer[10];

    public void push(int node) {
        //minstack要保留以往的最小值，这样pop的时候就不需要重新调整minStack
        ensureCapacity(size + 1);
        elements[size++] = node;
        if (node <= min) {
            minStack.push(node);
            min = minStack.peek();
        }else{
            minStack.push(min);
        }
        //    System.out.println(min+"");
    }

    private void ensureCapacity(int size) {
        // TODO Auto-generated method stub
        int len = elements.length;
        if (size > len) {
            int newLen = (len * 3) / 2 + 1; //每次扩容方式
            elements = Arrays.copyOf(elements, newLen);
        }
    }

    public void pop() {
        if (!empty()) {
            size--;
            minStack.pop();
            min = minStack.peek();
        } else {
            throw new IndexOutOfBoundsException("stack is empty");
        }
        //    System.out.println(min+"");
    }

    public int top() {
        if (!empty()) {
            return elements[size - 1];
        } else {
            throw new IndexOutOfBoundsException("stack is empty");
        }
    }

    public boolean empty() {
        return size == 0;
    }

    public int min() {
        if (!empty()) {
            return min;
        } else {
            throw new IndexOutOfBoundsException("stack is empty");
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(3);
        System.out.println(stack.min());
        stack.push(4);
        System.out.println(stack.min());
        stack.push(2);
        System.out.println(stack.min());
        stack.push(3);
        System.out.println(stack.min());
        stack.pop();


    }
}
