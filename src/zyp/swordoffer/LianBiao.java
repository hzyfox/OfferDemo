package zyp.swordoffer;

import zyp.structure.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author zyp
 */
public class LianBiao {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        ListNode ptr = listNode;
        while(ptr != null){
            stack.push(ptr.val);
            ptr = ptr.next;
        }
        while(!stack.isEmpty()){
            int x = stack.pop();
            list.add(x);
        }
        return  list;
    }

    public static void main(String[] args) {

    }
}
