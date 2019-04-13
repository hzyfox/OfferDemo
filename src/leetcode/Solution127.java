package leetcode;

import leetcode.util.Helper;

import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.List;

/**
 * create with leetcode
 * USER: husterfox
 */
public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        boolean[] symbol = new boolean[wordList.size()];
        ArrayList<String> store = new ArrayList<>();
        store.add(beginWord);
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        dfs(beginWord, endWord, wordList, store, result, symbol);
        if (!result.isEmpty()) {
            System.out.println(result.get(0));
        }
        return result.isEmpty() ? 0 : result.get(0).size();
    }

    public void dfs(String beginWord, String endWord, List<String> wordList, ArrayList<String> store, ArrayList<ArrayList<String>> result, boolean[] symbol) {
        if (!store.isEmpty() && store.get(store.size() - 1).equals(endWord)) {
            if (!result.isEmpty() && result.get(0).size() > store.size()) {
                result.remove(0);
                result.add((ArrayList<String>) store.clone());
                return;
            } else {
                result.add((ArrayList<String>) store.clone());
            }
        }
        for (int i = 0; i < wordList.size(); i++) {
            if (!symbol[i] && differ(beginWord, wordList.get(i)) == 1) {
                symbol[i] = true;
                store.add(wordList.get(i));
                dfs(wordList.get(i), endWord, wordList, store, result, symbol);
                symbol[i] = false;
                store.remove(store.size() - 1);
            }
        }
    }

    public int differ(String word0, String word1) {
        int cnt = 0;
        for (int i = 0; i < word0.length(); i++) {
            if (word0.charAt(i) != word1.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        List<String> wordList = Helper.stringToArray("[hot,cog,dog,tot,hog,hop,pot,dot]");
        System.out.println(new Solution127().ladderLength("hot", "dog", wordList));
    }
}
