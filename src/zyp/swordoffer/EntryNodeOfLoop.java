package zyp.swordoffer;

import zyp.structure.ListNode;

/**
 * @author zyp
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null||pHead.next==null){
            return pHead;
        }
        //在环内找到一个相遇的点
        ListNode slow = pHead.next;
        ListNode fast = slow.next;
        while (slow!=fast){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode p1 = fast;
        ListNode p2 = pHead;
        while (p1!=p2){
            p1 =p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
