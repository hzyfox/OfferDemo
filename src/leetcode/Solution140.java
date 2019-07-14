package leetcode;

import leetcode.util.Helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * create with leetcode
 * USER: husterfox
 */
public class Solution140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return dfs(s, set);
    }
    public ArrayList<String> dfs(String s, Set<String> set){
        if("".equals(s)){
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("");
            return arrayList;
        }
        ArrayList<String> res = new ArrayList<>();
        for(String word: set){
            if(s.startsWith(word)){
                for(String str: dfs(s.substring(word.length()), set)){
                    res.add(word + ("".equals(str) ? "" : " ")  + str);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution140 solution140 = new Solution140();
        String s = "catsanddog";
        List<String> wordDict = Helper.stringToStringList("[\"cat\", \"cats\", \"and\", \"sand\", \"dog\"]");
        System.out.println(solution140.wordBreak(s, wordDict));
    }
}

