import java.util.Random;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class SkipList {
    private int maxLevel = -1;
    private SkipListNode[] root;
    private int[] powers;
    private Random rd = new Random();

    SkipList() {
        this(4);
    }

    SkipList(int level) {
        assert level > 0 && level < 31;
        maxLevel = level;
        root = new SkipListNode[maxLevel];
        powers = new int[maxLevel];
        for (int i = 0; i < root.length; i++) {
            root[i] = null;
        }
        initPowers();
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList(4);
        skipList.insert(1);
        skipList.insert(2);
        skipList.insert(3);
        skipList.insert(4);
        skipList.insert(5);
        skipList.insert(6);
        System.out.println(skipList.search(2));
        System.out.println(skipList.search(1));
        skipList.delete(2);
        System.out.println(skipList.search(2));
    }

    /**
     * must be invoked in constructed method
     * e.g when level = 4 => powers: {15,7,3,1}
     * use at chooseLevel
     * P(X < 1) = 1/8 //level = 4
     * P(X < 3) = 2/8 //level = 3
     * P(X < 7) = 4/8 // level = 2
     * P(X ==7 && X<15) = 1/8 // level = 1
     */
    private void initPowers() {
        for (int i = maxLevel - 1, j = 0; i >= 0; i--, j++) {
            powers[i] = (2 << j) - 1;
        }
    }

    /**
     * @return logic level, at most maxLevel;
     */
    private int chooseLevel() {
        int i = rd.nextInt(1 << (maxLevel - 1));
        for (int j = maxLevel - 1; j >= 0; j--) {
            if (i < powers[j]) {
                return j + 1;
            }
        }
        return 1;
    }

    public boolean isEmpty() {
        return root[0] == null;
    }

    public int search(int key) {
        int lvl;
        SkipListNode prev, curr;
        for (lvl = maxLevel - 1; lvl >= 0 && root[lvl] == null; lvl--) {
            //to find the highest nonnull root
        }
        if (lvl < 0) {
            //SkipList is empty
            return -1;
        }
        prev = curr = root[lvl];
        while (true) {
            if (key == curr.value) {
                return curr.value;
            } else if (key < curr.value) {
                if (lvl == 0) {
                    //Not Found
                    return -1;
                } else if (curr == root[lvl]) {
                    curr = root[--lvl];
                } else {
                    curr = prev.next[--lvl];
                }
            } else {
                prev = curr;
                if (curr.next[lvl] != null) {
                    curr = curr.next[lvl];
                } else {
                    for (lvl--; lvl >= 0 && curr.next[lvl] == null; lvl--) {
                    }
                    if (lvl >= 0) {
                        curr = curr.next[lvl];
                    } else {
                        //Not Found
                        return -1;
                    }
                }
            }
        }
    }

    public int delete(int key) {
        SkipListNode[] curr = new SkipListNode[maxLevel];
        SkipListNode[] prev = new SkipListNode[maxLevel];
        int lvl;
        boolean findFlag = false;
        curr[maxLevel - 1] = root[maxLevel - 1];
        prev[maxLevel - 1] = null;
        for (lvl = maxLevel - 1; lvl >= 0; lvl--) {
            while (curr[lvl] != null && curr[lvl].value < key) {
                prev[lvl] = curr[lvl];
                curr[lvl] = curr[lvl].next[lvl];
            }
            if (curr[lvl] != null && key == curr[lvl].value) {
                findFlag = true;
            }
            if (lvl > 0) {
                if (prev[lvl] == null) {
                    curr[lvl - 1] = root[lvl - 1];
                    prev[lvl - 1] = null;
                } else {
                    curr[lvl - 1] = prev[lvl].next[lvl - 1];
                    prev[lvl - 1] = prev[lvl];
                }
            }
        }
        if (!findFlag) {
            //not found specific key
            return -1;
        }
        for (int i = 0; i < maxLevel; i++) {
            if (curr[i] == root[i] && curr[i] != null) {
                root[i] = curr[i].next[i];
            } else {
                if (prev[i] != null) {
                    prev[i].next = curr[i].next;
                }
            }
        }
        return key;
    }

    public void insert(int key) {
        SkipListNode[] curr = new SkipListNode[maxLevel];
        SkipListNode[] prev = new SkipListNode[maxLevel];
        SkipListNode newNode;
        int lvl, i;
        curr[maxLevel - 1] = root[maxLevel - 1];
        prev[maxLevel - 1] = null;
        for (lvl = maxLevel - 1; lvl >= 0; lvl--) {
            while (curr[lvl] != null && curr[lvl].value < key) {
                prev[lvl] = curr[lvl];
                curr[lvl] = curr[lvl].next[lvl];
            }
            if (curr[lvl] != null && key == curr[lvl].value) {
                return; //don't contain duplicate key
            }
            if (lvl > 0) {
                if (prev[lvl] == null) {
                    curr[lvl - 1] = root[lvl - 1];
                    prev[lvl - 1] = null;
                } else {
                    curr[lvl - 1] = prev[lvl].next[lvl - 1];
                    prev[lvl - 1] = prev[lvl];
                }
            }
        }
        lvl = chooseLevel();
        newNode = new SkipListNode(key, lvl);
        for (i = 0; i < lvl; i++) {
            newNode.next[i] = curr[i];
            if (prev[i] == null) {
                root[i] = newNode;
            } else {
                prev[i].next[i] = newNode;
            }
        }
    }
}


class SkipListNode {
    public int level = -1;
    public int value = -1;
    public SkipListNode[] next;

    public SkipListNode(int value, int level) {
        this.level = level;
        this.value = value;
        next = new SkipListNode[level];
        for (int i = 0; i < next.length; i++) {
            next[i] = null;
        }
    }
}
