package interview;

/**
 * 最长公共子串
 */
public class LongestCommonSequence {
    public static int lcs(char[] src, char[] dst) {
        int[][] dp = new int[src.length + 1][dst.length + 1];
        for (int i = 1; i < src.length + 1; i++) {
            for (int j = 1; j < dst.length + 1; j++) {
                if (src[i - 1] == dst[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[src.length][dst.length];
    }

    public static void main(String[] args) {
        char[] src = {'a', 'b', 'c'};
        char[] dst = {'b', 'a', 'c'};
        System.out.println(lcs(src, dst));
    }

}
