package zyp.swordoffer;

import zyp.structure.ListNode;

/**
 * @author zyp
 */
public class FindFirstCommonNode {

    /**
     * 设置p1,p2两个指针遍历两个链表，当其中一个遍历到尾部的时候，将指针指向另一个链表的头部，这样两个指针遍历的长度一样；
     *
     * 因为是公共节点，所以尾节点一定是一样的；
     * 所以两个指针遍历长度一样的链表时，一定会遍历到第一个相同的节点。
     * 例如 p1:0 1 2 3  4   5 null a b 4 5 null
     *     p2:a b 4 5 null 0   1  2 3 4 5 null
     */

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2){
        ListNode p1 = pHead1,p2 =pHead2;
        if(p1==null || p2==null){
            return null;
        }
        while (p1!=p2){
            p1 = p1==null?pHead2:p1.next;
            p2 = p2==null?pHead1:p2.next;
        }
        return p1;
    }


}
