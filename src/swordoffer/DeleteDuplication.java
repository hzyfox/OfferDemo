package swordoffer;

import leetcode.structure.ListNode;
import leetcode.util.Helper;

import java.util.List;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = pHead;
        ListNode prev = dummyHead;
        ListNode curr = pHead;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                int val = curr.val;
                while (curr != null && curr.val == val) {
                    curr = curr.next;
                }
                prev.next = curr;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return dummyHead.next;
    }

    //删除重复节点，但是保留一个
    public ListNode deleteDuplication0(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = pHead;
        ListNode prev = dummyHead;
        ListNode curr = pHead;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                int val = curr.val;
                ListNode node = null;
                while (curr != null && curr.val == val) {
                    node = curr;
                    curr = curr.next;
                }
                prev.next = node;
                prev = node;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode root = Helper.stringToListNode("[1,2,2,2,3,3,3,4,5,6,7,7]");
        System.out.println(Helper.listNodeToString(new DeleteDuplication().deleteDuplication0(root)));
    }
}
