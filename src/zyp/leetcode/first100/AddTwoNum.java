package zyp.leetcode.first100;

import zyp.structure.ListNode;

/**
 * @author zyp
 */
public class AddTwoNum {

    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode l = new ListNode(0);
        ListNode ptr = l;
        int flag = 0; //十位数
        while (l1 != null ) {
            if(l2 == null){
                   int  tmp = l1.val + 0 + flag;
                    ptr.next = new ListNode(tmp%10);
                    ptr = ptr.next;
                    flag = tmp / 10;
                l1 = l1.next;
            }else{
                int tmp = l1.val + l2.val + flag;
                ptr.next = new ListNode(tmp%10);
                ptr = ptr.next;
                flag = tmp / 10;
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        if(l2!= null){
            while (l2 != null) {
                int tmp = l2.val + flag;
                ptr.next= new ListNode(tmp % 10);
                flag = tmp / 10;
                ptr = ptr.next;
                l2 = l2.next;
            }
        }
        if(flag != 0) {
            System.out.println(flag);
            ptr.next = new ListNode(flag);
        }
        return  l.next;
    }
}
