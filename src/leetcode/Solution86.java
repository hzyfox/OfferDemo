package leetcode;

import leetcode.structure.ListNode;

public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        //找到第一个大于等于x的数,并记录其前面一位。
        ListNode target = null;
        ListNode beforeTarget = dummyHead;

        ListNode curr = head;
        while (curr != null) {
            if (curr.val >= x) {
                target = curr;
                break;
            } else {
                beforeTarget = curr;
                curr = curr.next;
            }
        }
        //没找到比target大的，说明链接已经天然符合要求
        if (target == null) {
            return head;
        }

        //将target后面所有比target小的数 移到前面 beforeTarget-> find -> target
        curr = target.next;
        ListNode prev = target;
        while (curr != null) {
            if (curr.val < x) {
                //断开curr,prev指向curr.next， prev无需更新
                prev.next = curr.next;

                //将curr拼接到target前面，更新beforeTarget为curr。
                ListNode tmp = curr.next;
                beforeTarget.next = curr;
                curr.next = target;
                beforeTarget = curr;

                //更新curr
                curr = tmp;
            } else {
                //更新prev 和 curr
                prev = curr;
                curr = curr.next;
            }
        }


        //链表最后一位补null
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode tmp = new Solution86().partition(head, 3);
        System.out.println(tmp);

    }
}
