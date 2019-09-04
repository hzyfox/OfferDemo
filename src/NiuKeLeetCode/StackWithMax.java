package NiuKeLeetCode;

import java.util.Stack;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */
public class StackWithMax {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> maxs = new Stack<>();
    private int max = Integer.MIN_VALUE;

    public void push(int e) {
        stack.push(e);
        if (e > max) {
            max = e;
            maxs.push(e);
        } else {
            maxs.push(max);
        }
    }

    public int pop() throws Exception {
        maxs.pop();
        if (!maxs.isEmpty()) {
            max = maxs.peek();
        } else {
            max = Integer.MIN_VALUE;
        }
        if (stack.isEmpty()) {
            throw new Exception("stack is empty");
        }
        return stack.pop();
    }

    public int max() throws Exception {
        if (maxs.isEmpty()) {
            throw new Exception("stack is empty");
        }
        return max;
    }


    public static void main(String[] args) throws Exception {
        StackWithMax stackWithMax = new StackWithMax();

        stackWithMax.push(1);
        System.out.println(stackWithMax.max());

        stackWithMax.push(2);
        System.out.println(stackWithMax.max());

        stackWithMax.pop();
        System.out.println(stackWithMax.max());

        stackWithMax.push(0);
        System.out.println(stackWithMax.max());


        stackWithMax.push(4);
        System.out.println(stackWithMax.max());

        stackWithMax.pop();
        System.out.println(stackWithMax.max());


    }

}
