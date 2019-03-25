package leetcode;

import java.util.*;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> store = new LinkedList<>();
        dfs(k, store, 1, n, result);
        return result;
    }

    public void dfs(int k, LinkedList<Integer> store, int pos, int n, List<List<Integer>> result) {
        if (store.size() == k) {
            result.add((LinkedList<Integer>) store.clone());
            return;
        }
        final int leftNumber = k - store.size();
        for (int i = pos; i <= n && n - pos + 1 >= leftNumber; i++) {
            store.add(i);
            dfs(k, store, i + 1, n, result);
            store.remove(store.size() - 1);
        }
    }

    public List<List<Integer>> iterativeCombine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> store = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            store.add(0);
        }
        int i = 0;
        while (i >= 0) {
            store.set(i, store.get(i) + 1);
            if (store.get(i) > n) {
                i--;
            } else {
                if (i == k - 1) {
                    result.add((ArrayList) store.clone());
                } else {
                    ++i;
                    store.set(i, store.get(i - 1));
                }
            }
        }
        return result;
    }




    public static void main(String[] args) {
        System.out.println(new Solution77().iterativeCombine(4, 3));
    }
}
