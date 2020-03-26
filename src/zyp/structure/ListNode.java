package zyp.structure;

/**
 * @author zyp
 */
public class ListNode {
    public int val;
    public ListNode next = null;
    public ListNode(int x) {val  = x;}

//    public int getVal() {
//        return val;
//    }
//
//    public ListNode getNext() {
//        return next;
//    }
//
//    public void setVal(int val) {
//        this.val = val;
//    }
//
//    public void setNext(ListNode next) {
//        this.next = next;
//    }
    public static ListNode   createList(int[] arr){
        ListNode listNode  = new ListNode(arr[0]);
        ListNode ptr = listNode;
        for(int i = 1;i<arr.length;i++){
            ListNode node = new ListNode(arr[i]);
            ptr.next = node;
            ptr = ptr.next;
        }
        return listNode;
    }

    public void  print(){
        ListNode ptr = this;
        while ((ptr!=null)){
            System.out.print(ptr.val);
            ptr = ptr.next;
        }
    }
}
