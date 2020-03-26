package zyp.swordoffer;

import leetcode.structure.RandomListNode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author zyp
 */
public class Clone {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null) {
            return null;
        }
        //第一步  复制新节点在旧节点后面 例如A A1 B B1
        RandomListNode curNode = pHead;
        while (curNode!=null){
            RandomListNode node = new RandomListNode(curNode.label);
            node.next = curNode.next;
            curNode.next = node;
            curNode = node.next;
        }
        //第二步 复制旧链表的random关系到新链表 例如A.next.random = A.random
        curNode = pHead;
        while (curNode!=null){
            curNode.next.random = curNode.random==null?null:curNode.random.next;
            curNode = curNode.next.next;
        }

        //第三步 将新链表与旧链表分割开来
        curNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(curNode != null) {
            RandomListNode cloneNode = curNode.next;
            curNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            curNode = curNode.next;
        }
        return pCloneHead;

    }
}
