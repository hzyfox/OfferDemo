package swordoffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class MaxInWindow {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (size <= 0) {
            return ans;
        }
        int maxIndex = -1;
        int max = -1;
        for (int i = 0; i < num.length - size + 1; i++) {
            if (maxIndex >= i) {
                if (num[i + size - 1] >= max) {
                    max = num[i + size - 1];
                    maxIndex = i + size - 1;
                }
                ans.add(max);
            } else {
                maxIndex = i;
                max = num[i];
                for (int j = i + 1; j < size + i; j++) {
                    if (num[j] >= max) {
                        max = num[j];
                        maxIndex = j;
                    }
                }
                ans.add(max);
            }
        }

        return ans;
    }

    public ArrayList<Integer> maxInWindows0(int[] num, int size) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            // 注意要用while循环 当deque不为空,比较队列尾，是否比num[i]大 且等于号也要加上，最大值应该为最新的下标
            while (!deque.isEmpty() && num[deque.peekLast()] <= num[i]) {
                deque.pollLast();
            }
            //如果deque不为空，且队列前面过期了
            while (!deque.isEmpty() && i - deque.peekFirst() + 1 > size) {
                deque.pollFirst();
            }
            deque.addLast(i);
            if (i + 1 >= size) {
                ans.add(num[deque.peekFirst()]);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] test = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(new MaxInWindow().maxInWindows0(test, 3));
    }
}

