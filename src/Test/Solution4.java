package Test;

import java.util.Scanner;

/**
 * @author zyp
 */
public class Solution4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] mn = scanner.nextLine().split(" ");
        int m = Integer.valueOf(mn[0]);
        int K = Integer.valueOf(mn[1]);
        String rep = scanner.nextLine();
        String[] repstrs = rep.split(" ");

        long[] nums = new long[m];
        for (int i = 0; i < m; i++) {
            nums[i] = Integer.valueOf(repstrs[i]);
        }

        long[][] dp = new long[m][m];
        long max = 0;
        dp[0][0] = 1;
        for(int i = 0;i < m;i++){
            for(int j = i+1;j<m;j++){
                if(j-i+1>K){
                    if(nums[j]==nums[i]){
                        dp[i][j] = dp[i][j-1]+1;
                    }else{
                        if(j-dp[i][j-1]<=K){
                            dp[i][j] = dp[i][j-1];
                        }else{
                            break;
                        }
                    }
                }else{
                    if(nums[j]==nums[i]){
                        dp[i][j] = dp[i][j-1]+1;
                    }else{
                        dp[i][j] = dp[i][j-1];
                    }
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        System.out.println(max);
    }
}
