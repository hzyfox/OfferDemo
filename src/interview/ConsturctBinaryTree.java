package interview;

import leetcode.structure.ListNode;
import leetcode.structure.TreeNode;
import leetcode.util.Helper;

import java.util.ArrayList;

/**
 * 求1-n 个数 能构建二叉搜索树的数目
 */
public class ConsturctBinaryTree {
    public static int numTrees(int n) {
        int[] cache = new int[n];
        return cal(n, cache);
    }

    public static int cal(int n, int[] cache) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (cache[n - 1] != 0) {
            return cache[n - 1];
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += cal(i-1, cache) * cal(n - i, cache);
        }
        cache[n - 1] = sum;
        return sum;
    }

    public static ArrayList<TreeNode> dfsTree(int start, int end) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        if (start == end) {
            ans.add(new TreeNode(start));
            return ans;
        }
        if (start > end) {
            ans.add(null);
            return ans;
        }

        for (int i = start; i <= end; i++) {
            for (TreeNode left : dfsTree(start, i - 1)) {
                for (TreeNode right : dfsTree(i + 1, end)) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        for(TreeNode root: dfsTree(1,3)){
            System.out.println(Helper.treeNodeToString(root));
        }
        System.out.println(numTrees(3));
    }
}
