/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l1Tmp = l1;
        ListNode l2Tmp = l2;
        ListNode head = null;
        ListNode headTmp = null;
        while (l1Tmp != null && l2Tmp != null) {
            if (l1Tmp.val < l2Tmp.val) {
                if (head == null) {
                    head = l1Tmp;
                    headTmp = head;
                } else {
                    headTmp.next = l1Tmp;
                    headTmp = headTmp.next;
                }
                l1Tmp = l1Tmp.next;
            } else {
                if (head == null) {
                    head = l2Tmp;
                    headTmp = head;
                } else {
                    headTmp.next = l1Tmp;
                    headTmp = headTmp.next;
                }
                l2Tmp = l2Tmp.next;
            }
        }
        if (l1Tmp == null) {
            while (l2Tmp != null) {
                if (head == null) {
                    head = l2Tmp;
                    headTmp = head;
                } else {
                    headTmp.next = l2Tmp;
                    l2Tmp = l2Tmp.next;
                }
            }
        } else {
            while (l1Tmp != null) {
                if (head == null) {
                    head = l1Tmp;
                    headTmp = head;
                } else {
                    headTmp.next = l1Tmp;
                    l1Tmp = l1Tmp.next;
                }
            }
        }
        return head;
    }
}
