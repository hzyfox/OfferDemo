package swordoffer;

import java.util.Stack;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class IsPopOrder {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int a = 0;
        int b = 0;
        stack.push(pushA[a]);
        while (a < pushA.length && b < popA.length) {
            if (stack.peek() != popA[b]) {
                a++;
                if (a < pushA.length) {
                    stack.push(pushA[a]);
                }
            } else {
                stack.pop();
                b++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,3,5,1,2};
        System.out.println(new IsPopOrder().IsPopOrder(pushA,popA));
    }
}
