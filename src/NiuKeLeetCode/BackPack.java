package NiuKeLeetCode;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */
public class BackPack {
    public static void backPack(int[] weight, int[] value, int capacity) {
        int[][] dp = new int[weight.length+1][capacity + 1];
        //
        for (int i = 1; i < weight.length + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - weight[i - 1]] + value[i - 1],dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[weight.length][capacity]);
    }

    public static void main(String[] args) {
        int[] weight = {10,5,5};
        int[] value = {5,3,3};
        backPack(weight, value,10);
    }
}
