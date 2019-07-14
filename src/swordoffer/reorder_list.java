package swordoffer;

import leetcode.structure.ListNode;
import leetcode.util.Helper;

public class reorder_list {
    public void reorderList(ListNode head) {
        if(head ==null || head.next == null){
            return;
        }
        ListNode p = head;
        ListNode q = p.next;
        while(p!= null && q!=null && q.next != null){
            p = p.next;
            if(q.next!=null){
                q = q.next.next;
            }else{
                break;
            }
        }

        ListNode start = p.next;
        p.next = null;
        ListNode prev = null;
        ListNode curr = start;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        start = head;
        curr = prev;
        while(curr != null){
            ListNode next = start.next;
            ListNode next1 = curr.next;
            start.next = curr;
            curr.next = next;
            curr = next1;
            start = next;
        }

    }

    public static void main(String[] args) {
        reorder_list reorderList = new reorder_list();
        ListNode head = Helper.stringToListNode("[0,1,2,3,4]");
        reorderList.reorderList(head);
        System.out.println(Helper.listNodeToString(head));
    }
}
