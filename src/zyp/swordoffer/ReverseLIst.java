package zyp.swordoffer;

import leetcode.structure.ListNode;

/**
 * @author zyp
 */
public class ReverseLIst {
    public ListNode ReverseList(ListNode head){
       if(head == null){
           return  head;
       }
       ListNode pre=null,next=null;
       while ((head!=null)){
           next = head.next;
           head.next = pre;
           pre = head;
           head = next;
       }
       return  pre;
    }
}
