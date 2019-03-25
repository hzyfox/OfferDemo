package leetcode;

import leetcode.structure.ListNode;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
/**
 * Definition for singly-linked list.
 * public class leetcode.structure.ListNode {
 *     int val;
 *     leetcode.structure.ListNode next;
 *     leetcode.structure.ListNode(int x) { val = x; }
 * }
 *
 *----------------------------
 *prev
 *tail   head
 *dummy   1    2    3   4    5
 *----------------------------
 *prev   head      tail
 *dummy   1    2    3   4    5
 *       cur
 *----------------------------
 * 每次让prev.next的元素插入到当前tail之后,这样tail不断前移,被挪动的元素头插入tail之后的链表
 *prev        tail head
 *dummy   2    3    1   4    5
 *       cur
 *----------------------------
 *prev   tail      head
 *dummy   3    2    1   4    5
 *       cur
 *----------------------------
 *                 prev
 *                 tail
 *                 head
 *dummy   3    2    1   4    5
 *----------------------------
 *                 prev  head     tail
 *dummy   3    2    1     4    5  null
 *----------------------------
 */
public class ReverseNodesInkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, tail = dummy, cur;
        int count;
        while (true) {
            count = k;
            while (count != 0 && tail != null) {
                tail = tail.next;
                count--;
            }
            if (tail == null) {
                break;
            }
            head = prev.next;
            while (prev.next != tail) {
                cur = prev.next;
                prev.next = cur.next;
                cur.next = tail.next;
                tail.next = cur;
            }
            prev = head;
            tail = head;
        }
        return dummy.next;


    }
}
