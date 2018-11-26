/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */

import java.util.Random;

public class SkipListTest {
    public static void main(String[] args) {
        list2Test(5);
        list2Test(5);
    }

    public static void listTest(int max) {
        SkipList skipList = new SkipList(4);
        skipList.setDebug(true);
        for (int i = 0; i < max; i++) {
            skipList.insert(i);
        }
        skipList.iteratorSkipList();
    }

    public static void list2Test(int max) {
        SkipList2 skipList2 = new SkipList2(4);
        skipList2.setDebug(true);
        for (int i = 0; i < max; i++) {
            skipList2.insert(i);
        }
        skipList2.iteratorSkipList();
    }
}

class SkipList2 {
    private final SkipListNode2[] root;
    private final int maxLevel;
    private boolean debug = false;

    SkipList2(int maxLevel) {
        this.maxLevel = maxLevel;
        int level = maxLevel;
        root = new SkipListNode2[maxLevel];
        while (level-- != 0) {
            root[level] = new SkipListNode2();
        }
        level = maxLevel;
        while (level-- > 1) {
            root[level].downNext = root[level - 1];
        }
    }

    private int chooseLevel() {
        int level = 1;
        Random random = new Random();
        //这里要用while循环，不用if否则不能体现一直抛硬币
        while (random.nextInt() % 2 == 0) {
            level++;
        }
        return (level < maxLevel) ? level : maxLevel;
    }

    void insert(int value) {
        int level = chooseLevel();
        if (debug) {
            System.out.format("insert node %d into level %d \n", value, level);
        }
        SkipListNode2 preNode = null;
        SkipListNode2 currentNode = root[level - 1];
        SkipListNode2[] insertedNodes = new SkipListNode2[level];
        //这里要注意最高层的level要和底层level的节点连接起来
        for (int i = 0; i < insertedNodes.length; i++) {
            insertedNodes[i] = new SkipListNode2(value);
        }
        for (int i = level - 1; i >= 1; i--) {
            insertedNodes[i].downNext = insertedNodes[i - 1];
        }
        while (level-- != 0) {
            while (currentNode != null && currentNode.val <= value) {
                preNode = currentNode;
                currentNode = currentNode.next;
            }

            preNode.next = insertedNodes[level];
            insertedNodes[level].next = currentNode;
            preNode = preNode.downNext;
            currentNode = preNode;
        }
    }

    boolean find(int val) {
        int level = maxLevel;
        SkipListNode2 currentNode = root[level - 1];
        SkipListNode2 preNode = currentNode;
        while (level-- != 0) {
            while (currentNode != null && currentNode.val <= val) {
                if (currentNode.val == val) {
                    return true;
                }
                preNode = currentNode;
                currentNode = currentNode.next;
            }
            currentNode = preNode.downNext;
            preNode = currentNode;
        }
        return false;
    }

    boolean delete(int val) {
        int level = maxLevel;
        SkipListNode2 currentNode = root[level - 1];
        SkipListNode2 preNode = currentNode;
        boolean deleteFlag = false;
        while (level-- != 0) {
            //防止删掉了root节点，所以用<=
            while (currentNode != null && currentNode.val <= val) {
                if (currentNode != root[level] && currentNode.val == val) {
                    deleteFlag = true;
                    preNode.next = currentNode.next;
                    //这里记得要加break 重新从preNode遍历。否则下层节点不会被删除
                    break;
                }
                preNode = currentNode;
                currentNode = currentNode.next;
            }
            currentNode = preNode.downNext;
            preNode = currentNode;
        }
        return deleteFlag;
    }

    void iteratorSkipList() {
        int level = maxLevel;
        while (level-- != 0) {
            SkipListNode2 currentNode = root[level];
            while (currentNode != null) {
                System.out.printf(" %4d -> ", currentNode.val);
                currentNode = currentNode.next;
            }
            System.out.printf(" null ");
            System.out.printf("\n");
        }
    }

    void setDebug(boolean flag) {
        debug = flag;
    }
}


class SkipListNode2 {
    //can be a reference  to a value
    int val;
    SkipListNode2 next = null;
    SkipListNode2 downNext = null;

    SkipListNode2() {
        val = Integer.MIN_VALUE;
    }

    SkipListNode2(int value) {
        val = value;
    }
}

class SkipList {
    final private SkipListNode root;
    private int maxLevel;
    private boolean debug = false;

    SkipList(int maxLevel) {
        root = new SkipListNode(maxLevel);
        this.maxLevel = maxLevel;
    }

    public void setDebug(boolean flag) {
        debug = flag;
    }

    private int chooseLevel() {
        int level = 1;
        Random random = new Random();
        while (random.nextInt() % 2 == 0) {
            level++;
        }
        return (level < maxLevel) ? level : maxLevel;
    }


    void insert(int value) {
        int level = chooseLevel();
        if (debug) {
            System.out.format("insert node %d into level %d \n", value, level);
        }
        SkipListNode insertNode = new SkipListNode(maxLevel, value);
        NodeReference[] currentReferences = root.references;
        NodeReference[] preReferences = currentReferences;

        while (level-- != 0) {
            //为了保证root不变 所以需要用<= 保证新进来的值如果相等是插在右边。
            while (currentReferences != null && currentReferences[level].outerNode.val <= value) {
                if (currentReferences[level].next != null) {
                    preReferences = currentReferences;
                    currentReferences = currentReferences[level].next.outerNode.references;
                } else {
                    preReferences = currentReferences;
                    currentReferences = null;
                }
            }
            if (currentReferences == null) {
                preReferences[level].next = insertNode.references[level];
            } else {
                preReferences[level].next = insertNode.references[level];
                insertNode.references[level].next = currentReferences[level];
            }
            currentReferences = preReferences;
        }
    }

    boolean find(int val) {
        int level = maxLevel;
        NodeReference[] currentReferences = root.references;
        NodeReference[] preReferences = currentReferences;
        while (level-- != 0) {
            while (currentReferences != null && currentReferences[level].outerNode.val <= val) {
                if (currentReferences[level].outerNode.val == val) {
                    return true;
                }
                if (currentReferences[level].next != null) {
                    preReferences = currentReferences;
                    currentReferences = currentReferences[level].next.outerNode.references;
                } else {
                    preReferences = currentReferences;
                    currentReferences = null;
                }
            }
            currentReferences = preReferences;
        }
        return false;
    }

    boolean delete(int val) {
        int level = maxLevel;
        NodeReference[] currentReferences = root.references;
        NodeReference[] preReferences = currentReferences;
        boolean findFlag = false;
        while (level-- != 0) {
            while (currentReferences != null && currentReferences[level].outerNode.val <= val) {
                if (currentReferences != root.references && currentReferences[level].outerNode.val == val) {
                    findFlag = false;
                    if (currentReferences[level].next != null) {
                        preReferences[level].next = currentReferences[level].next.outerNode.references[level];
                        findFlag = true;
                        break;
                    } else {
                        preReferences[level].next = null;
                        findFlag = true;
                        break;
                    }
                }
                if (currentReferences[level].next != null) {
                    preReferences = currentReferences;
                    currentReferences = currentReferences[level].next.outerNode.references;
                } else {
                    preReferences = currentReferences;
                    currentReferences = null;
                }
            }
            currentReferences = preReferences;
        }
        return findFlag;
    }

    void iteratorSkipList() {
        int level = maxLevel;
        NodeReference[] currentReferences = root.references;
        while (level-- != 0) {
            while (currentReferences != null) {
                System.out.printf(" %4d -> ", currentReferences[level].outerNode.val);
                if (currentReferences[level].next != null) {
                    currentReferences = currentReferences[level].next.outerNode.references;
                } else {
                    currentReferences = null;
                }
            }
            System.out.printf(" null ");
            System.out.printf("\n");
            currentReferences = root.references;
        }
    }
}

class SkipListNode {
    int val;
    NodeReference[] references;

    private SkipListNode() {
        val = Integer.MIN_VALUE;
    }

    SkipListNode(int maxLevel) {
        this();
        references = new NodeReference[maxLevel];
        for (int i = 0; i < references.length; i++) {
            references[i] = new NodeReference();
            references[i].outerNode = this;
        }

    }

    SkipListNode(int maxLevel, int value) {
        this(maxLevel);
        val = value;
    }
}

class NodeReference {
    SkipListNode outerNode = null;
    NodeReference next = null;
}