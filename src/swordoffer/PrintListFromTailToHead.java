package swordoffer;

import leetcode.structure.ListNode;

import java.util.ArrayList;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ans = new ArrayList<>();
        while (listNode != null) {
            ans.add(0,listNode.val);
            listNode = listNode.next;
        }
        return ans;
    }
}
