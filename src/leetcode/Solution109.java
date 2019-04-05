package leetcode;

import leetcode.structure.ListNode;
import leetcode.structure.TreeNode;
import leetcode.util.Helper;

import java.util.ArrayList;

/**
 * create with leetcode
 * USER: husterfox
 */
public class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode curr = head;
        while(curr!=null){
            list.add(curr);
            curr = curr.next;
        }
        return build(list, 0, list.size()-1);

    }
    public TreeNode build(ArrayList<ListNode> list, int start, int end){
        if(start > end){
            return null;
        }
        if(start == end){
            return new TreeNode(list.get(start).val);
        }
        //+1 保证大小顺序
        int mid = (end+start+1)/2;
        TreeNode root = new TreeNode(list.get(mid).val);
        root.left = build(list, start, mid-1);
        root.right = build(list,mid+1,end);
        return root;
    }

    public static void main(String[] args) {
        new Solution109().sortedListToBST(Helper.stringToListNode("[-10,-3,0,5,9]"));
    }
}
