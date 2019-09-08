package interview;

import java.util.Random;

/**
 * 跳表的简单实现
 */
class SkipListNode {
    int val;
    SkipListNode down;
    SkipListNode next;

    SkipListNode(int value) {
        val = value;
    }
}

public class SkipList {
    private final int maxLevel;
    private SkipListNode[] roots;
    private Random random = new Random();

    public SkipList(int level) {
        this.maxLevel = level;
        roots = new SkipListNode[level];
        for (int i = 0; i < level; i++) {
            roots[i] = new SkipListNode(Integer.MIN_VALUE);
        }
        for (int i = level - 1; i > 0; i--) {
            roots[i].down = roots[i - 1];
        }
    }

    private int chooseLevel() {
        int curLevel = 1;
        while ((random.nextInt() & 1) == 0) {
            curLevel++;
        }
        return curLevel > maxLevel ? maxLevel : curLevel;
    }

    public void insert(int val) {
        int level = chooseLevel();
        System.out.println(" insert val : " + val + " level : " + level);
        SkipListNode[] insertNodes = new SkipListNode[level];
        for (int i = 0; i < level; i++) {
            insertNodes[i] = new SkipListNode(val);
        }
        for (int i = level - 1; i > 0; i--) {
            insertNodes[i].down = insertNodes[i - 1];
        }
        SkipListNode preNode = roots[level - 1];
        SkipListNode currNode = preNode;
        while (level-- != 0) {
            while (currNode != null && currNode.val <= val) {
                preNode = currNode;
                currNode = currNode.next;
            }
            preNode.next = insertNodes[level];
            insertNodes[level].next = currNode;

            preNode = preNode.down;
            currNode = preNode;
        }
    }

    public boolean find(int val) {
        int level = maxLevel;
        SkipListNode preNode = roots[maxLevel - 1];
        SkipListNode currNode = preNode;
        while (level-- != 0) {
            while (currNode != null && currNode.val <= val) {
                if (currNode.val == val && currNode != roots[level]) {
                    return true;
                }
                preNode = currNode;
                currNode = currNode.next;
            }
            preNode = preNode.down;
            currNode = preNode;
        }
        return false;
    }

    public boolean delete(int val) {
        int level = maxLevel;
        SkipListNode preNode = roots[level - 1];
        SkipListNode currNode = preNode;
        boolean flag = false;

        while (level-- != 0) {
            while (currNode != null && currNode.val <= val) {
                if (currNode != roots[level] && currNode.val == val) {
                    preNode.next = currNode.next;
                    flag = true;
                    break;
                }
                preNode = currNode;
                currNode = currNode.next;
            }
            preNode = preNode.down;
            currNode = preNode;
        }
        return flag;
    }

    void iteratorSkipList() {
        int level = maxLevel;
        while (level-- != 0) {
            SkipListNode currentNode = roots[level];
            while (currentNode != null) {
                System.out.printf(" %4d -> ", currentNode.val);
                currentNode = currentNode.next;
            }
            System.out.printf(" null ");
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList(4);
        for (int i = 0; i < 5; i++) {
            skipList.insert(i);
        }
        skipList.iteratorSkipList();
    }
}
