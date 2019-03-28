package swordoffer;

import leetcode.SmallRootHeap;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {


        ArrayList<String> ans = new ArrayList<>();
        StringBuilder store = new StringBuilder();
        ArrayList<Integer> index = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return ans;
        }
        char[] input = str.toCharArray();
        Arrays.sort(input);
        bfs(ans, index, store, input, 0);
        return ans;
    }

    public void bfs(ArrayList<String> ans, ArrayList<Integer> index, StringBuilder store, char[] input, int pos) {
        if (pos == input.length) {
            ans.add(store.toString());
            return;
        }
        for (int i = 0; i < input.length; i++) {
            if (!index.contains(i)) {
                index.add(i);
                store.append(input[i]);
                bfs(ans, index, store, input, pos + 1);
                store.deleteCharAt(store.length() - 1);
                index.remove(index.size() - 1);
                while (i + 1 < input.length && input[i + 1] == input[i]) {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permutation().Permutation("abc"));
    }
}
