package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Pjb {
    public static void main(String[] args) {
        Pjb pjb = new Pjb();
        System.out.println(pjb.longestValidParentheses(")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())"));
    }

    public int longestValidParentheses(String s) {
        int[] indices = new int[s.length()];
        ArrayList<Integer> indexRecord = new ArrayList<>();
        int left = -1;
        int right = 1;
        int empty = 0xBAD;
        int max = 0;
        int currMax = 0;
        Stack<IndexSymbol> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(new IndexSymbol(left, i));
            } else {
                //现在是right
                if (!stack.empty()) {
                    IndexSymbol curr = stack.peek();
                    if (curr.left_right == left) {
                        stack.pop();
                        indexRecord.add(curr.index);
                        indexRecord.add(i);
                    } else {
                        stack.push(new IndexSymbol(right, i));
                    }
                }else{
                    stack.push(new IndexSymbol(right, i));
                }
            }
        }
        Iterator<Integer> indexIterator = indexRecord.iterator();
        while (indexIterator.hasNext()) {
            int index = indexIterator.next();
            indices[index] = empty;
        }
        for (int i = 0; i < indices.length; i++) {
            if (indices[i] == empty) {
                currMax++;
            } else {
                if (currMax > max) {
                    max = currMax;
                }
                currMax = 0;
            }
        }
        //防止最后出现连续的empty
        if(currMax > max){
            max = currMax;
        }
        return max;
    }

    class IndexSymbol {
        int left_right;
        int index;

        public IndexSymbol(int left_right, int index) {
            this.left_right = left_right;
            this.index = index;
        }
    }

}
