package NiuKeLeetCode;

import java.util.Arrays;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */
public class AscSubArray {
    public static void ascSubArray(int[] arr) {
        //以arr[i]结束的最长子数组长度
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && dp[j] > max){
                    max = dp[i];
                }
                dp[i] = max + 1;
            }
            maxLen = Math.max(dp[i], maxLen);
        }
        System.out.println(maxLen);
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,3};
        ascSubArray(arr);
    }
}
