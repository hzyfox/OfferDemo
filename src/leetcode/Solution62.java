package leetcode;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */


public class Solution62 {
    public int uniquePaths(int m, int n) {
//        使用m+1 n+1,可以给首行 首列赋值为1，可以合并为一个循环。 此时第一行（从0算）相当于下面代码的第0行
//        int[][] dp = new int[m + 1][n + 1];
//        dp[0][1] = 1;
//        for (int i = 1; i < m + 1; i++) {
//            for (int j = 1; j < n + 1; j++) {
//                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
//            }
//        }
//        return dp[m][n];
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j-1];
            }
        }
        return dp[m - 1][n - 1];
    }


    public static void main(String[] args) {
        System.out.println(new Solution62().uniquePaths(7, 3));
    }

}
