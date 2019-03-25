package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Solution93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        LinkedList<String> store = new LinkedList<String>() {
            @Override
            public String toString() {
                StringBuilder str = new StringBuilder();
                for (String string : this) {
                    str.append(string);
                }
                return str.toString().substring(1);
            }
        };
        dfs(4, result, store, s, 0);
        return result;
    }

    public void dfs(int k, List<String> result, List<String> store, String s, int strStartPos) {
        if (k == 0) {
            String str = store.toString();
            //由于转字符串的时候多了3个'.' 所以要减3
            if (str.length() - 3 == s.length()) {
                result.add(str);
            }
            return;
        }
        //要保证当前能有足够长的字符串构成ip 因为后续k次每次至多拿3个所以 strStartPos + k * 3 >= s.length() 又因为至少拿1个所以strStartPos + k <= s.length() 这样可以防止多拿和少拿
        //要保证i从一个合理的范围开始， 比如 还剩8个字符 k=3,因为后面k-1次 最多拿 3*（k-1）次
        for (int i = Math.max(0, (s.length() - strStartPos) - 3 * (k - 1) - 1); i < 3 && strStartPos + k * 3 >= s.length() && strStartPos + k <= s.length(); i++) {
            try {
                String subStr = s.substring(strStartPos, strStartPos + i + 1);
                int ip = Integer.valueOf(subStr);
                if (ip <= 255 && (!subStr.startsWith("0") || (subStr.length() == 1 && ip == 0))) {
                    store.add("." + subStr);
                    dfs(k - 1, result, store, s, strStartPos + i + 1);
                    store.remove(store.size() - 1);
                }
            } catch (StringIndexOutOfBoundsException e) {
                //store is not long enough, we catch the exception
            }
        }
    }

    public List<String> iterativeRestoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();


        for (int i = 1; i <= s.length() - 3 && i <= 3; i++) {
            for (int j = i + 1; j <= s.length() - 2 && j - i <= 3; j++) {
                for (int k = j + 1; k <= s.length() - 1 && k - j <= 3; k++) {
                    if (s.length() - k > 3) {
                        continue;
                    }
                    String ip0 = s.substring(0, i);
                    String ip1 = s.substring(i, j);
                    String ip2 = s.substring(j, k);
                    String ip3 = s.substring(k);
                    if (isValid(ip0) && isValid(ip1) && isValid(ip2) && isValid(ip3)) {
                        result.add(ip0 + "." + ip1 + "." + ip2 + "." + ip3);
                    }
                }
            }
        }
        return result;
    }

    public boolean isValid(String ip) {
        return Integer.valueOf(ip) <= 255 && ((!ip.startsWith("0")) || (ip.length() == 1 && ip.charAt(0) == '0'));
    }


    public static void main(String[] args) {
        System.out.println(new Solution93().iterativeRestoreIpAddresses("123123123123"));
    }
}
