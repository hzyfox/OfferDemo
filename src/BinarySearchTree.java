import java.util.Stack;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class BinarySearchTree {
    public static BstWithParents findMax(BstWithParents root) {
        if (root == null) {
            throw new NullPointerException("root can't be null");
        }
        if (root.left == null && root.right == null) {
            return root;
        } else if (root.right != null) {
            return findMax(root.right);
        } else {
            return root;
        }
    }

    public static BstWithParents findMin(BstWithParents root) {
        if (root == null) {
            throw new NullPointerException("root can't be null");
        }
        if (root.left == null && root.right == null) {
            return root;
        } else if (root.left != null) {
            return findMin(root.left);
        } else {
            return root;
        }
    }

    public static BstWithParents findPredecessor(BstWithParents target, BstWithParents root) {
        if (target == null) {
            throw new NullPointerException("target can't be null");
        }
        if (root == null) {
            throw new NullPointerException("root can't be null");
        }
        if (target.left != null) {
            findMax(target.left);
        } else {
            //有左父母
            if (target.parents != null && target.leftParent()) {
                return target.parents;
            } else {
                //有右父母
                if (target.parents != null && (target.parents.parents != null && target.parents.leftParent())) {
                    return target.parents.parents;
                }
            }
        }
        return null;
    }

    public static BstWithParents findPredecessorWithoutParents(BstWithParents target, BstWithParents root) {
        if (target == null) {
            throw new NullPointerException("target can't be null");
        }
        if (root == null) {
            throw new NullPointerException("root can't be null");
        }
        if (target.left != null) {
            return findMax(target.left);
        } else {
            Stack<BstWithParents> stack = new Stack<>();
            while (root != target) {
                stack.push(root);
                if (target.value < root.value) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            BstWithParents son, parent = null;
            son = target;

            while (!stack.empty() && (parent = stack.pop()).right != son) {
                son = parent;
            }
            //没找到
            if (stack.empty() && parent.right != son) {
                return null;
            }
            return parent;
        }
    }

    public static BstWithParents findSuccessoor(BstWithParents target, BstWithParents root) {
        if (target == null) {
            throw new NullPointerException("target can't be null");
        }
        if (root == null) {
            throw new NullPointerException("root can't be null");
        }
        if (target.right != null) {
            return findMin(target.right);
        } else {
            Stack<BstWithParents> stack = new Stack<>();
            while (root != target) {
                stack.push(root);
                if (target.value < root.value) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            BstWithParents son, parent = null;
            son = target;
            while (!stack.empty() && (parent = stack.pop()).left != son) {
                son = parent;
            }
            if (stack.empty() && parent.left != son) {
                return null;
            }
            return parent;
        }
    }


    public static void main(String[] args) {
        BstWithParents root = new BstWithParents(5);
        root.left = new BstWithParents(3);
        root.left.parents = root;
        root.left.right = new BstWithParents(4);
        root.left.right.parents = root.left;
        root.left.left = new BstWithParents(2);
        root.left.left.parents = root.left;
        root.right = new BstWithParents(8);
        root.right.parents = root;
        root.right.left = new BstWithParents(7);
        root.right.left.parents = root.right;
        root.right.right = new BstWithParents(9);
        root.right.right.parents = root.right;
        System.out.println(findMax(root));
        System.out.println(findPredecessor(root.left, root));
        System.out.println(findPredecessorWithoutParents(root.left.right, root));
        System.out.println(findPredecessorWithoutParents(root.left.left, root));
        System.out.println(findSuccessoor(root, root));
    }
}


class BstWithParents {
    BstWithParents left = null;
    BstWithParents right = null;
    BstWithParents parents = null;
    int value;

    public BstWithParents(int value) {
        this.value = value;
    }

    public boolean leftParent() {
        assert parents != null;
        return parents.right == this;
    }

    public boolean rightParent() {
        assert parents != null;
        return parents.left == this;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
