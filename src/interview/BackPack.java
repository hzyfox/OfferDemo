package interview;

/**
 * 背包问题
 */
public class BackPack {
    //01 背包
    public static void backPack01(int[] weight, int[] value, int capacity) {
//        int[][] dp = new int[weight.length + 1][capacity + 1];
//        //
//        for (int i = 1; i < weight.length + 1; i++) {
//            for (int j = 1; j < capacity + 1; j++) {
//                if (j < weight[i - 1]) {
//                    dp[i][j] = dp[i - 1][j];
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j - weight[i - 1]] + value[i - 1], dp[i - 1][j]);
//                }
//            }
//        }
//        System.out.println("backPack01: " + dp[weight.length][capacity]);
        int[] dp = new int[capacity + 1];
        for (int i = 1; i < weight.length + 1; i++) {
            for (int j = capacity; j >= weight[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i - 1]] + value[i - 1]);
            }
        }
        System.out.println("backPack01: " + dp[capacity]);
    }
    //完全背包
    public static void backpackComplete(int[] weight, int[] value, int capacity) {
        int[] dp = new int[capacity + 1];

        for (int i = 1; i < weight.length + 1; i++) {
            for (int j = weight[i - 1]; j < capacity + 1; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i - 1]] + value[i - 1]);
            }
        }
        System.out.println("backpackComplete: " + dp[capacity]);
    }
    //多重背包
    public static void backPackMultiple(int[] weight, int[] value, int capacity, int[] m) {
        int[][] dp = new int[weight.length + 1][capacity + 1];
        for (int i = 1; i < weight.length + 1; i++) {
            for (int j = weight[i - 1]; j < capacity + 1; j++) {
                for (int k = 1; k <= m[i - 1]; k++) {
                    if (j >= k * weight[i - 1]) {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i - 1][j - k * weight[i - 1]] + k * value[i - 1]);
                    }
                }
            }
        }
        System.out.println("backPackMultiple: " + dp[weight.length][capacity]);

        //也可以将m扩展到weight 数组 和 value数组后，单独的作为01背包问题
    }


    public static void main(String[] args) {
        int[] weight = {3, 3, 3};
        int[] value = {10, 6, 6};
        int[] m = {3,1,1};
        backPack01(weight, value, 10);
        backpackComplete(weight, value, 10);
        backPackMultiple(weight,value,10,m);
    }
}
