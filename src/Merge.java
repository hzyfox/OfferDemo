/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Merge {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode pre1 = null;
        ListNode pre2;
        ListNode head = list1;
        if (temp1 == null && temp2 == null) {
            return null;
        }
        if (temp1 == null) {
            return temp2;
        }
        if (temp2 == null) {
            return temp1;
        }
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                pre1 = temp1;
                temp1 = temp1.next;
            } else {
                if (pre1 == null) {
                    pre2 = temp2;
                    temp2 = temp2.next;
                    pre2.next = temp1;
                    head = pre2;
                } else {
                    pre2 = temp2;
                    temp2 = temp2.next;
                    pre1.next = pre2;
                    pre2.next = temp1;
                }
            }
        }
        if (temp1 == null) {
            pre1.next = temp2;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode list1 = listNode1;
        listNode1.next = new ListNode(3);
        listNode1 = listNode1.next;
        listNode1.next = new ListNode(5);

        ListNode listNode2 = new ListNode(1);
        ListNode list2 = listNode2;
        listNode2.next = new ListNode(3);
        listNode2 = listNode2.next;
        listNode2.next = new ListNode(5);

        ListNode listNode = new Merge().Merge(list1,list2);
        ListNode temp = listNode;
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }

    }

}

