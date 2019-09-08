package interview;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 硬币问题
 */
public class Coins {
    //求能凑出1-target 价值需要的最少钱币
    public ArrayList<Integer> one2Target(int[] coins, int target) {
        int sum = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= target; i++) {
            if (i > sum) {
                for (int j = coins.length - 1; j >= 0; j--) {
                    if (coins[j] < target) {
                        sum += coins[j];
                        ans.add(coins[j]);
                        break;
                    }
                }
            }
            if (i > sum) {
                System.out.println("can't do that");
                return new ArrayList<>();
            }
        }
        return ans;
    }
    //求能凑出target价值需要的最少钱币
    public static void specificCoins(int[] coins, int target) {
        if (target <= 0) {
            return;
        }
        int[] dp = new int[target + 1];
        Arrays.fill(dp, 99999);
        dp[0] = 0;
        int min = 99999;
        for (int i = 1; i < target + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(min, dp[i - coins[j]] + 1);
                }
            }
        }
        System.out.println(dp[target]);
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10};
        specificCoins(coins, 20);
    }
}
