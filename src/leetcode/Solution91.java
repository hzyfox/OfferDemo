package leetcode;

public class Solution91 {
    public int numDecodings(String s) {
        //如果最后两个可以组合成一个 那么dp=dp[i-2]， 如果最后两个不能组合成一个dp[i] = dp[i-1]
        //dp[i] = dp[i-1] + dp[i-2]
        int[] dp = new int[s.length()];
        if (s.length() == 1) {
            if (s.charAt(0) == '0') {
                return 0;
            } else {
                return 1;
            }
        }
        dp[0] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            int lastTowNum = Integer.valueOf(s.substring(i - 1, i + 1));
            if (lastTowNum >= 10 && lastTowNum <= 26) {
                dp[i] += i > 1 ? dp[i - 2] : 1;
            }
            if (s.charAt(i) != '0') {
                dp[i] += dp[i - 1];
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        new Solution91().numDecodings("1010");
    }
}
