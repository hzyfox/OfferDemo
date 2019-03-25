package leetcode;

import leetcode.structure.ListNode;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tmpHead = head;
        ListNode tail = null;
        int listCnt = 0;
        while (tmpHead != null) {
            listCnt += 1;
            tail = tmpHead;
            tmpHead = tmpHead.next;
        }
        System.out.println(listCnt);
        if (listCnt <= 1) {
            return head;
        }
        k = k % listCnt;
        if (k == 0) {
            return head;
        }
        tmpHead = head;
        int i = 0;
        while (tmpHead != null) {
            i += 1;
            if (i == (listCnt - k)) {
                ListNode preHead = head;
                head = tmpHead.next;
                tmpHead.next = null;
                tail.next = preHead;
                break;
            }
            tmpHead = tmpHead.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = null;
        new Solution61().rotateRight(head,2);
    }
}
