package interview;

import leetcode.structure.ListNode;
import leetcode.util.Helper;

/**
 * 链表的快速排序 和 归并排序
 */
public class LinkedListSort {
    public static void main(String[] args) {
        ListNode root = Helper.stringToListNode("[1,3,2,6,5]");
        root = mergeSort(root, null);
        System.out.println(Helper.listNodeToString(root));

    }

    public static ListNode quickSort(ListNode root, ListNode start, ListNode end) {
        if (start == end) {
            return root;
        }
        ListNode head = root;
        ListNode curr = root.next;
        ListNode pre = root;
        while (curr != null) {
            if (curr.val < root.val) {
                pre.next = curr.next;
                curr.next = head;
                head = curr;
                curr = pre.next;
            } else {
                pre = curr;
                curr = curr.next;
            }
        }
        //这里要注意root 需要连接 右一半.
        ListNode head1 = quickSort(head, head, root);
        root.next = quickSort(root.next, root.next, end);
        return head1;
    }

    public static ListNode mergeSort(ListNode root, ListNode end) {
        if (root == end) {
            return root;
        }
        //这里要注意 fast 要从root.next 开始，否则 当元素只有两个时，会陷入死循环。
        ListNode fast = root.next;
        ListNode slow = root;
        while (slow != null && fast != null && fast.next!=null) {
            slow = slow.next;

            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode s0 = mergeSort(root, slow);
        ListNode s1 = mergeSort(tmp, end);
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        while (s0 != null && s1 != null) {
            if (s0.val < s1.val) {
                curr.next = s0;
                curr = curr.next;
                s0 = s0.next;
            } else {
                curr.next = s1;
                curr = curr.next;
                s1 = s1.next;
            }
        }
        if (s0 != null) {
            curr.next = s0;
        }
        if (s1 != null) {
            curr.next = s1;
        }

        return dummyHead.next;
    }


}
