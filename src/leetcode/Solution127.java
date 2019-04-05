package leetcode;

import leetcode.util.Helper;


import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * create with leetcode
 * USER: husterfox
 */
public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        HashSet<String> wordListSet = new HashSet<>(wordList);
        HashSet<String> reached = new HashSet<>();

        int distance = 1;
        reached.add(beginWord);
        while (!reached.contains(endWord)) {
            HashSet<String> toAdd = new HashSet<>();
            distance++;
            for (String word : reached) {
                for (int i = 0; i < word.length(); i++) {
                    char[] letters = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        letters[i] = ch;
                        String newWord = new String(letters);
                        if (wordListSet.contains(newWord)) {
                            toAdd.add(newWord);
                            wordListSet.remove(newWord);
                        }
                    }
                    if (toAdd.contains(endWord)) {
                        return distance;
                    }
                }
            }
            if (toAdd.size() == 0) {
                return 0;
            }
            reached = toAdd;
        }
        return distance;
    }


    public static void main(String[] args) {
        List<String> wordList = Helper.stringToArray("[hot,dot,dog,lot,log,cog]");
        System.out.println(new Solution127().ladderLength("hit", "cog", wordList));
    }
}
