package NiuKeLeetCode;

import leetcode.structure.ListNode;
import leetcode.util.Helper;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */
public class insertion_sort_list {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head.next;
        ListNode preCurr = head;
        while (curr != null) {
            ListNode tmp = head;
            ListNode prev = tmp;
            while (tmp != curr) {
                if (tmp.val < curr.val) {
                    prev = tmp;
                    tmp = tmp.next;
                } else {
                    break;
                }
            }
            if (tmp == head) {
                ListNode currNext = curr.next;
                preCurr.next = curr.next;
                curr.next = tmp;
                head = curr;
                curr = currNext;
            } else if (tmp == curr) {
                preCurr = curr;
                curr = curr.next;
            } else {
                ListNode currNext = curr.next;
                preCurr.next = curr.next;
                prev.next = curr;
                curr.next = tmp;
                curr = currNext;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        insertion_sort_list insertionSortList = new insertion_sort_list();
        ListNode root = Helper.stringToListNode("[2,1,3,5,4]");
        System.out.println(Helper.listNodeToString(insertionSortList.insertionSortList(root)));
    }
}
