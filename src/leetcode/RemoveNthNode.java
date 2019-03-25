package leetcode;

import leetcode.structure.ListNode;

import java.util.ArrayList;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        ArrayList<ListNode> container = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            container.add(tmp);
            tmp = tmp.next;
        }
        if(n == container.size()){
            return head = container.get(0).next;
        }
        ListNode pre = container.get(container.size() - (n + 1));
        pre.next = container.get(container.size() - n).next;
        return head;
    }
}
