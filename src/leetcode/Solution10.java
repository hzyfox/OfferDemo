package leetcode;

/**
 * create with leetcode
 * USER: husterfox
 */
public class Solution10 {
    public boolean isMatch(String s, String p) {
        //we use dp
        //  null a b c * c
        //null    1  0 0 0 0 0
        // a      0  1 0 0 0 0
        // b      0  0 1 0 1 0
        // c      0  0 0 1 1 1
        // if(p[j]！=*） s[i] == p[j] || p[i] == . 时， dp[i][j] = d[i-1][j-1] else dp[i][j] = 0
        //if(p[j] == *) if(s[i] != p[j-1]) 时， 此时*号只能代表出现0次 dp[i][j] = dp[i][j-2];
        // if(s[i] == p[j-1])时，此时*号可以有三种情况
        // *号出现0次 dp[i][j] = dp[i][j-2];
        // *号出现1次 dp[i][j] = dp[i][j-1];
        // *号出现多次 dp[i][j] = dp[i-1][j] 这里*代表出现了多次 所以前面也出现*号前面的内容
        if (s == null) {
            return p == null;
        }
        if (p == null) {
            return s == null;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1]; //多出来的1表示为空时
        dp[0][0] = true; //模式为空时， 字符串也为空，此时匹配
        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = false;
        }
        for (int i = 1; i <= p.length(); i++) {
            //当字符串为空时，模式必须在偶数位* 且前面也满足该条件 如 a*b*c*
            if ((i & 1) == 0 && dp[0][i - 2] && p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) != '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = true;
                    }
                } else {
                    if (p.charAt(j - 1) == '*') {
                        if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                            dp[i][j] = dp[i][j - 2];
                        } else {
                            dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                        }
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public boolean isMatch0(char[] str, char[] pattern, int strIndex, int patternIndex) {
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] != '*') {
            if (strIndex < str.length && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')) {
                return isMatch0(str, pattern, strIndex + 1, patternIndex + 1);
            } else {
                return false;
            }
        } else {
            if (strIndex < str.length && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')) {
                return isMatch0(str, pattern, strIndex, patternIndex + 2) || isMatch0(str, pattern, strIndex + 1, patternIndex);
            } else {
                return isMatch0(str, pattern, strIndex, patternIndex + 2);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution10().isMatch0("aab".toCharArray(), "c*a*b*".toCharArray(), 0, 0));
    }
}
