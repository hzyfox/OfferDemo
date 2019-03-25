package leetcode;

import leetcode.structure.ListNode;

import java.util.ArrayList;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */

public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode temp = listNode;
        ListNode pre;
        ListNode next;
        if(listNode == null){
            return new ArrayList<Integer>();
        }else{
            if(listNode.next == null){
                ArrayList<Integer> arrayList = new ArrayList<Integer>(1);
                arrayList.add(listNode.val);
                return arrayList;
            }else {
                int count = 0;
                next = temp.next;
                while (next != null) {
                    count++;
                    pre = temp;
                    temp = next;
                    next = next.next;
                    temp.next = pre;
                }
                count++;
                listNode.next = null;
                ArrayList<Integer> arrayList = new ArrayList<Integer>(count);
                while(temp != null){
                    arrayList.add(temp.val);
                    temp = temp.next;
                }
                return arrayList;
            }
        }
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(67);
        ListNode head = listNode;
        listNode.next = new ListNode(0);
        listNode = listNode.next;
        listNode.next = new ListNode(24);
        listNode = listNode.next;
        listNode.next = new ListNode(58);
        ArrayList<Integer> arrayList = new PrintListFromTailToHead().printListFromTailToHead(head);
        System.out.println(arrayList);
    }
}




