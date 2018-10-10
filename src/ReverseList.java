/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode temp = head;
        ListNode pre;
        ListNode next = temp.next;
        while (next != null){
            pre = temp;
            temp = next;
            next = next.next;
            temp.next = pre;
        }
        head.next = null;
        return temp;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
