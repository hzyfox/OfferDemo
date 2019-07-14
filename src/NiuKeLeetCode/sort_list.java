package NiuKeLeetCode;

import leetcode.structure.ListNode;
import leetcode.util.Helper;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */
public class sort_list {
    public static void main(String[] args) {
        sort_list sortList = new sort_list();
        ListNode root = Helper.stringToListNode("[3,4,1]");
        System.out.println(Helper.listNodeToString(sortList.sortList(root)));
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode tmp = middle.next;
        middle.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(left != null && right != null){
            if(left.val <= right.val){
                curr.next = left;
                left = left.next;
                curr = curr.next;
            }else{
                curr.next = right;
                right = right.next;
                curr = curr.next;
            }
        }
        while(left != null){
            curr.next = left;
            curr = curr.next;
            left = left.next;
        }
        while(right != null){
            curr.next = right;
            curr = curr.next;
            right = right.next;
        }
        return dummy.next;
    }

    public ListNode findMiddle(ListNode head){
        if(head == null){
            return null;
        }
        ListNode p =  head;
        ListNode q = p.next;
        while(p != null && q != null && q.next != null){
            p = p.next;
            if(q.next == null){
                break;
            }else{
                q = q.next.next;
            }
        }
        return p;
    }
}
