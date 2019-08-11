package NiuKeLeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */
public class WordBreak {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        return dfs(s, dict, map);
    }

    public ArrayList<String> dfs(String s, Set<String> dict, HashMap<String, ArrayList<String>> map){
        ArrayList<String> ans = new ArrayList<>();
        if("".equals(s)){
            ans.add("");
            return ans;

        }
        if(map.containsKey(s)){
            return map.get(s);
        }
        for(int i = 1; i <= s.length(); i++){
            String sub = s.substring(0, i);
            if(dict.contains(sub)){
                for(String tmp :  dfs(s.substring(i, s.length()), dict, map)){
                    ans.add(sub + ("".equals(tmp) ? "" : " ") + tmp);
                }
            }
        }
        map.put(s, ans);
        return ans;
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        HashSet<String> dict= new HashSet<>();
        dict.add("a");
        wordBreak.wordBreak("a", dict);
    }
}
