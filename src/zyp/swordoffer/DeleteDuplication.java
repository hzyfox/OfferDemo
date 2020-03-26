package zyp.swordoffer;

import zyp.structure.ListNode;

/**
 * @author zyp
 */
public class DeleteDuplication {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 1, 2};
        ListNode head = ListNode.createList(arr);
        DeleteDuplication.deleteDuplication(head);
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = pHead;
        ListNode pre = newHead;  //pre 指向前一个不重复的点
        ListNode last = pHead;  //last 指向下一个不重复的点
        while (last != null) {
            if (last.next != null && last.val == last.next.val) {
                while (last.next != null && last.val == last.next.val) {
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            } else {
                pre = pre.next;
                last = last.next;
            }
        }
        return newHead.next;

    }

    //递归写法
    public ListNode deleteDuplication2(ListNode pHead) {
        if(pHead==null||pHead.next==null){
            return pHead;
        }
        if(pHead.val==pHead.next.val){   //当前节点是重复节点
            ListNode tmp = pHead.next;
            while (tmp.next!=null&&tmp.val==tmp.next.val){
                tmp = tmp.next;
            }
            return deleteDuplication2(tmp.next);
        }else {
            pHead.next = deleteDuplication2(pHead.next);  //当前节点是非重复节点
            return pHead;
        }
    }
}