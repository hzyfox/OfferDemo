package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * create with jvm.heap.review
 * USER: husterfox
 */
public class DFS {
    public static void main(String[] args) {
        Tree root = new Tree(0);
        Tree tmpRoot = root;
        for (int i = 1; i < 10; ) {
            tmpRoot.left = new Tree(i++);
            tmpRoot.right = new Tree(i++);
            tmpRoot = tmpRoot.left;
        }
        Stack<Tree> stack = new Stack<>();
        ArrayList<Integer> dfsList = new ArrayList<>();
        if (root != null) {
            tmpRoot = root;
            stack.push(tmpRoot);
            while (!stack.isEmpty()) {
                tmpRoot = stack.pop();
                dfsList.add(tmpRoot.value);
                if (tmpRoot.right != null) {
                    stack.push(tmpRoot.right);
                }
                if (tmpRoot.left != null) {
                    stack.push(tmpRoot.left);
                }
            }
        }
        dfsList.stream().forEach(System.out::println);
        ArrayList<Integer> bfsList = new ArrayList<>();
        LinkedList<Tree> queue = new LinkedList<>();
        if (root != null) {
            tmpRoot = root;
            queue.offer(tmpRoot);
            while (!queue.isEmpty()) {
                tmpRoot = queue.poll();
                bfsList.add(tmpRoot.value);
                if (tmpRoot.left != null) {
                    queue.offer(tmpRoot.left);
                }
                if (tmpRoot.right != null) {
                    queue.offer(tmpRoot.right);
                }
            }
        }
        bfsList.stream().forEach(System.out::println);
    }

    static class Tree {
        Tree left;
        Tree right;
        int value;

        Tree(int value) {
            this.value = value;
        }
    }
}
