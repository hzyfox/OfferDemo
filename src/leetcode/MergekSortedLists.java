package leetcode;

import leetcode.structure.ListNode;

import java.util.Arrays;
import java.util.Objects;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head;
        head = merge(null, null, lists);
        return head;
    }

    public ListNode merge(ListNode head, ListNode tmp, ListNode[] lists) {
        if (lists.length == 0) {
            return  head;
        }
        while (Arrays.stream(lists).noneMatch(Objects::isNull)) {
            int minNode = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[minNode].val > lists[i].val) {
                    minNode = i;
                }
            }
            if (head == null) {
                tmp = head = lists[minNode];
                lists[minNode] = lists[minNode].next;
            } else {
                tmp.next = lists[minNode];
                tmp = tmp.next;
                lists[minNode] = lists[minNode].next;
            }

        }
        Object[] filter = Arrays.stream(lists).filter(Objects::nonNull).toArray();
        ListNode[] tmpLists = new ListNode[filter.length];
        for (int i = 0; i < filter.length; i++) {
            tmpLists[i] = (ListNode)filter[i];
        }
        head = merge(head, tmp, tmpLists);
        return head;
    }

    public static void main(String[] args) {
        ListNode list0 = null;


        ListNode list1 = new ListNode(1);



        ListNode[] listArrays = new ListNode[2];
        listArrays[0] = list0;
        listArrays[1] = list1;


        ListNode head = new MergekSortedLists().mergeKLists(listArrays);
        System.out.println(head);
    }
}
