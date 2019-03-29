package swordoffer;

import leetcode.structure.ListNode;

import java.util.Stack;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class FirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode curr = pHead1;
        while (curr != null) {
            stack1.push(curr);
            curr = curr.next;
        }
        curr = pHead2;
        while (curr != null) {
            stack2.push(curr);
            curr = curr.next;
        }
        if (stack1.isEmpty() || stack2.isEmpty()) {
            return null;
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.peek() == stack2.peek()) {
                stack1.pop();
                stack2.pop();
            } else {
                return stack1.pop().next;
            }
        }
        //会执行到这一步 说明两条链表重合
        return stack1.isEmpty() ? pHead1 : pHead2;
    }

    public ListNode FindFirstCommonNode0(ListNode pHead1, ListNode pHead2) {
        //如果head1 和 head2 一样长，且有公共节点，则直接能碰到公共节点
        //如果head1 和 head2 一样长，且没有公共节点，则head1 和 head2 直接到null
        //如果head1 和 head2 一样长，且有公共节点，这里我们假设 head1较短，则head1先到null。此时head1等于phead2， head2继续往前前走，head1也跟着走，当head2走完时，此时head1刚好走完phead2比phead1多出来的长度
        //此时head2 = phead1，相当于head2 和 head1在一样长的长度起步往下找， 当有公共节点时，一定可以找到公共节点，当没有时，返回null
        ListNode head1 = pHead1;
        ListNode head2 = pHead2;
        while (head1 != head2) {
            head1 = head1 == null ? pHead2 : head1.next;
            head2 = head2 == null ? pHead1 : head2.next;
        }
        return head1;
    }
}
