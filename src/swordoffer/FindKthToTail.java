package swordoffer;

import leetcode.structure.ListNode;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode pre = head, last = head;
        for (int i = 1; i < k; i++) {
            if (pre.next != null) {
                pre = pre.next;
            } else {
                return null;
            }
        }
        while (pre.next != null) {
            pre = pre.next;
            last = last.next;
        }
        return last;
    }

}
