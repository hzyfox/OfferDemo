package leetcode;

import java.util.ArrayList;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        if(k < 0){
            return null;
        }
        ArrayList<ListNode> listNodes = new ArrayList<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            listNodes.add(temp);
            temp = temp.next;
        }
        if(listNodes.size() < k){
            return null;
        }
        return listNodes.get(listNodes.size() - k);
    }

    public static void main(String[] args) {

    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
