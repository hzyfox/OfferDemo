package zyp.swordoffer;

import zyp.structure.ListNode;

/**
 * @author zyp
 */
public class Merge {
    public ListNode Merge(ListNode list1,ListNode list2){
        if(list1 == null){
            return  list2;
        }
        if(list2 == null){
            return  list1;
        }
        ListNode ptr1 ;
        ListNode ptr2 ;
        if(list1.val > list2.val){
            ptr1 = list2;
            ptr2 = list1;
        }else {
            ptr1 = list1;
            ptr2 =  list2;
        }
        ListNode pre = null;
        while(ptr1!=null && ptr2!= null){
            if(ptr2.val >= ptr1.val){
                while(ptr1!=null && ptr2.val >= ptr1.val){
                    pre =ptr1;
                    ptr1 = ptr1.next;
                }
                if(ptr1 == null){
                    pre.next = ptr2;
                    break;
                }
                ListNode tmp = ptr2.next;
                pre.next= ptr2;
                pre = pre.next;
                pre.next = ptr1;
                ptr2 = tmp;
            }else {
                ListNode tmp = ptr2.next;
                pre.next = ptr2;
                pre = pre.next;
                pre.next = ptr1;
                ptr2 = tmp;
            }

        }
        return list1.val>list2.val?list2:list1;
    }


    public ListNode merge2(ListNode list1,ListNode list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return  list1;
        }
        if(list1.val <= list2.val){
            list1.next = merge2(list1.next,list2);
            return  list1;
        }else {
            list2.next = merge2(list1,list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[] a = {3,3,4};
        int[] b = {4,5,6};
        ListNode list1  = ListNode.createList(a);
        ListNode list2 = ListNode.createList(b);
        ListNode result = merge.Merge(list1,list2);
        result.print();
        System.out.println(result);
    }
}
