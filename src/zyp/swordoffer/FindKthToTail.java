package zyp.swordoffer;

import zyp.structure.ListNode;

import java.util.ArrayList;

/**
 * @author zyp
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head == null || k == 0){ return null;}
        ArrayList<ListNode> arrayList = new ArrayList<>();
        ListNode ptr = head;
        int length = 0;
        while (ptr!=null){
            arrayList.add(ptr);
            ptr = ptr.next;
            length ++;
        }
        return length < k?null:arrayList.get(length-k);

    }

    public ListNode FindKthToTail2(ListNode head,int k){
        ListNode p,q;
        p=q=head;
        int i=0;
        while(p!=null){
            if(i>=k){
                q=q.next;
            }
            p=p.next;
            i++;
        }
        return i<k?null:q;
    }

}
