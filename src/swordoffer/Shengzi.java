package swordoffer;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class Shengzi {
    public static void main(String[] args) {
        System.out.println(cutRope(6));
    }

    public static int cutRope(int target) {
        int[] dp = new int[target + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            int tmp = i;
            for (int j = i - 1; j >= 0; j--) {
                tmp = Math.max(dp[j] * dp[i - j], tmp);
            }
            dp[i] = tmp;
        }
        return dp[target];
    }
}
