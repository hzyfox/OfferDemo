package swordoffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
        List<String> s= new ArrayList<>();
        s.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,3,5,1,2};
        System.out.println(new IsPopOrder().IsPopOrder(pushA,popA));
    }
}
