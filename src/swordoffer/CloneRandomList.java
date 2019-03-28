package swordoffer;

import leetcode.structure.RandomListNode;

import java.util.LinkedList;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class CloneRandomList {
    public RandomListNode Clone(RandomListNode pHead) {

        if (pHead == null) {
            return null;
        }
        RandomListNode currNode = pHead;
        while (currNode != null) {
            RandomListNode node = new RandomListNode(currNode.label);
            node.next = currNode.next;
            currNode.next = node;
            currNode = node.next;
        }
        currNode = pHead;
        while (currNode != null) {
            RandomListNode node = currNode.next;
            if (currNode.random != null) {
                node.random = currNode.random.next;
            }
            currNode = node.next;
        }
        //拆分,两条链表都拆分好了，不能损坏原来的链表
        RandomListNode pCloneHead = pHead.next;
        RandomListNode tmp;
        currNode = pHead;
        while (currNode.next != null) {
            tmp = currNode.next;
            currNode.next = tmp.next;
            currNode = tmp;
        }
        return pCloneHead;
    }

    public static String RandomListNodeToString(RandomListNode head) {
        RandomListNode curr = head;
        if (curr == null) {
            return "null";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        while (curr != null) {
            builder.append(curr.label);
            builder.append(",");
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                builder.append(curr.random.label);
            } else {
                builder.append("#");
            }
            builder.append(",");
            curr = curr.next;
        }
        if (builder.charAt(builder.length() - 1) == ',') {
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
        RandomListNode head0 = new RandomListNode(1);
        RandomListNode head1 = new RandomListNode(2);
        RandomListNode head2 = new RandomListNode(3);
        RandomListNode head3 = new RandomListNode(4);
        RandomListNode head4 = new RandomListNode(5);


        head0.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = null;


        head0.random = head4;
        head1.random = null;
        head2.random = null;
        head3.random = null;
        head4.random = null;

        RandomListNode head = new CloneRandomList().Clone(head0);

        if (head == head0) {
            System.out.println("equal");
        }
        System.out.println(CloneRandomList.RandomListNodeToString(head));
        System.out.println(CloneRandomList.RandomListNodeToString(head0));
    }
}
