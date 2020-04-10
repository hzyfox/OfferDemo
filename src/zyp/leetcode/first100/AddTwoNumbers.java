package zyp.leetcode.first100;

import zyp.structure.ListNode;

/**
 * @author zyp
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(8);
        ListNode node2 = new ListNode(0);
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        System.out.println(        addTwoNumbers.addTwoNumbers(node1,node2));
     }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode res = new ListNode(0);
        ListNode ptr = res;
       while (l1!=null||l2!=null){
           int x = l1==null?0:l1.val;
           int y = l2==null?0:l2.val;
           int sum = x+y+flag;
           flag = sum/10;
           ptr.next = new ListNode(sum%10);
           ptr = ptr.next;
           l1 = l1==null?l1:l1.next;
           l2 = l2==null?l2:l2.next;
       }
        if(flag>0){
           ptr.next = new ListNode(flag);
        }
        return res.next;
    }
}
