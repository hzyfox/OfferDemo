package swordoffer;

import leetcode.structure.ListNode;
import leetcode.util.Helper;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class Merge {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        while (list1!= null && list2!= null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;

            } else {
                curr.next = list2;
                list2 = list2.next;

            }
            curr = curr.next;
        }
        if(list1 == null && list2 == null){
            return dummyHead.next;
        }else{
            if(list1 == null){
                curr.next = list2;
            }else{
                curr.next = list1;
            }
            return dummyHead.next;
        }
    }

    public static void main(String[] args) {
        ListNode root0 = Helper.stringToListNode("[1,3,5]");
        ListNode root1 = Helper.stringToListNode("[2,4,6]");
        System.out.println(Helper.listNodeToString(new Merge().Merge(root0,root1)));

    }
}
