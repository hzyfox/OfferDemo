package swordoffer;

import java.util.LinkedList;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class LastRemaining {
    public int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> children = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            children.add(i);
        }
        int index = -1;
        while (children.size() > 1) {
            index = (index + m) % (children.size());
            children.remove(index);
            index = index - 1;

        }
        return children.poll();
    }

    public static void main(String[] args) {
        System.out.println(new LastRemaining().LastRemaining_Solution(5, 3));
    }
}
