package leetcode;

import leetcode.structure.ListNode;

public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode consultNode = null;
        ListNode curr = head;
        boolean repeated = false;
        while (curr != null) {
            if (consultNode == null) {
                consultNode = curr;
                curr = curr.next;
                if (curr != null && curr.val != consultNode.val) {
                    prev = consultNode;
                }
            } else {
                if (curr.val == consultNode.val) {
                    curr = curr.next;
                    repeated = true;
                } else {
                    if (repeated) {
                        repeated = false;
                        prev.next = curr;
                    }
                    consultNode = curr;
                    curr = curr.next;
                    if (curr != null && curr.val != consultNode.val) {
                        prev = consultNode;
                    }

                }
            }
        }
        if (repeated) {
            prev.next = null;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        ListNode tmp = new Solution82().deleteDuplicates(head);
        System.out.println(tmp);

    }
}
