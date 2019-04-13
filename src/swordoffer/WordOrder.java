package swordoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class WordOrder {
    public static int arrangeOrderWord(String[] arr) {
        boolean[] symbol = new boolean[arr.length];
        for (String str : arr) {
            if (dfs(arr, symbol, 0, str)) {
                return 1;
            }
        }
        return -1;
    }

    public static boolean dfs(String[] arr, boolean[] symbol, int index, String word) {
        if (index == arr.length) {
            return true;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!symbol[i] && word.charAt(word.length() - 1) == arr[i].charAt(0)) {
                symbol[i] = true;
                if (dfs(arr, symbol, index + 1, arr[i])) {
                    return true;
                } else {
                    symbol[i] = false;
                }
            }
        }
        return false;
    }

    public static int arrange(String[] arr, ArrayList<String> store, ArrayList<Integer> index) {
        if (store.size() == arr.length) {
            System.out.println(store);
            return 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!index.contains(i)) {
                if (store.isEmpty()) {
                    store.add(arr[i]);
                    index.add(i);
                    if (arrange(arr, store, index) == 1) {
                        return 1;
                    } else {
                        store.remove(store.size() - 1);
                        index.remove(index.size() - 1);
                    }
                } else {
                    String tmp = store.get(store.size() - 1);
                    if (tmp.charAt(tmp.length() - 1) == arr[i].charAt(0)) {
                        store.add(arr[i]);
                        index.add(i);
                        if (arrange(arr, store, index) == 1) {
                            return 1;
                        } else {
                            store.remove(store.size() - 1);
                            index.remove(index.size() - 1);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] arr = {
                "abc",
                "cba",
                "ca"
        };
        System.out.println(WordOrder.arrangeOrderWord(arr));
    }
}
