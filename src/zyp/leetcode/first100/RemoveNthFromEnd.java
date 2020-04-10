package zyp.leetcode.first100;

import zyp.structure.ListNode;

import java.util.Arrays;

/**
 * @author zyp
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        RemoveNthFromEnd r = new RemoveNthFromEnd();
        ListNode head = ListNode.createList(new int[]{1,2,3,4,5});
        r.removeNthFromEnd(head,2);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n<=0){
            return null;
        }
        int i =0,j=0;
        ListNode ptr1 = head;
        ListNode ptr2 = null;
        for(i=1;i<n&&ptr1!=null;i++){
            ptr1 = ptr1.next;
        }
        if(i<n){
            return null;
        }
        if(i==n&&ptr1.next==null){
            head = head.next;
            return head;
        }
        while (ptr1.next!=null){
            ptr1 = ptr1.next;
            if(ptr2==null){
                ptr2 = head;
            }else{
                ptr2 = ptr2.next;
            }
        }
        ptr2.next = ptr2.next.next;
        return head;
    }
}
