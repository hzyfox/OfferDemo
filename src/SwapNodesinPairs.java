import java.util.Stack;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> container = new Stack<>();
        ListNode curr = new ListNode(-1), tmp = head;
        ListNode returHead = curr;
        while (tmp != null) {
            container.push(tmp);
            tmp = tmp.next;
            if (container.size() == 2) {
                returHead.next = container.pop();
                returHead = returHead.next;
                returHead.next = container.pop();
                returHead = returHead.next;
            }
        }
        if (!container.isEmpty()) {
            returHead.next = container.pop();
            returHead.next.next = null;
        }else{
            returHead.next = null;
        }
        return curr.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        ListNode head = new SwapNodesinPairs().swapPairs(root);
        System.out.println(head);
    }
}
