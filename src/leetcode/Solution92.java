package leetcode;

import leetcode.structure.ListNode;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m==n){
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curr = head;
        ListNode prev = dummyHead;
        ListNode mNode =head;
        int cnt = 0;
        while(curr != null && cnt<=n){
            cnt++;
            if(cnt <= m){
                if(cnt == m-1){
                    prev = curr;
                }else{
                    if(cnt == m){
                        mNode = curr;
                    }
                }
                curr = curr.next;
            } else {
                if (cnt <= n) {
                    //保存curr.next
                    ListNode tmpCurrNext = curr.next;
                    //保存prev.next
                    ListNode tmpPrevNext = prev.next;
                    //断开当前节点
                    mNode.next = curr.next;
                    //将curr移到前面
                    prev.next = curr;
                    curr.next = tmpPrevNext;
                    //更新curr
                    curr = tmpCurrNext;
                }
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode tmp;
        tmp = new Solution92().reverseBetween(head,2,4);
        System.out.println(tmp);
    }
}
