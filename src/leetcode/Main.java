package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * create with leetcode
 * USER: husterfox
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str0 = scanner.nextLine().split(" ");


        int m = Integer.valueOf(str0[0]);
        int n = Integer.valueOf(str0[1]);
        ArrayList<Integer> moneyList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            moneyList.add(Integer.valueOf(scanner.nextLine()));
        }

        HashMap<Integer, Integer> moneys = new HashMap<>();

        for (int i = 1; i <= m; i++) {
            if (moneys.containsKey(i)) {
                continue;
            } else {
                if (moneyList.contains(i)) {
                    moneys.put(i, 1);
                }else{

                }
            }
        }
    }

//    public static int minMoney(int[] wuliNums, int[] moneyNums, int index, int sumWuli, int sumMoney) {
//        if (index == moneyNums.length) {
//            return sumMoney;
//        }
//        if (sumWuli < 0) {
//            return -1;
//        }
//        //买
//        int left = minMoney(wuliNums, moneyNums, index + 1, sumWuli + wuliNums[index], sumMoney + moneyNums[index]);
//        //不买
//        int right = minMoney(wuliNums, moneyNums, index + 1, sumWuli - wuliNums[index], sumMoney);
//
//        if (left == -1 && right != -1) {
//            return right;
//        }
//        if (left != -1 && right == -1) {
//            return left;
//        }
//        if (left != -1 && right != -1) {
//            return Math.min(left, right);
//        }
//        return -1;
////        Scanner scanner = new Scanner(System.in);
//        int n = Integer.valueOf(scanner.nextLine());
//        String wuli = scanner.nextLine();
//        String money = scanner.nextLine();
//        String[] wuliStrs = wuli.split(" ");
//        String[] moneyStrs = money.split(" ");
//        int N = 55;
//        long[][] dp = new long[N][N * 2];
//        for(int i = 0; i<N; i++){
//            for(int j = 0; j<2*N; j++){
//                dp[i][j] = -1;
//            }
//        }
////        int[] wuliNums = new int[wuliStrs.length];
////        int[] moneyNums = new int[moneyStrs.length];
////        for (int i = 0; i < wuliStrs.length; i++) {
////            wuliNums[i] = Integer.valueOf(wuliStrs[i]);
////            moneyNums[i] = Integer.valueOf(moneyStrs[i]);
////        }
////        dp[0][moneyNums[0]] = wuliNums[0];
////
////        for (int i = 1; i < n; ++i) {
////            for (int j = 1; j < N * 2; ++j) {
////                if (dp[i - 1][j] > -1) {
////                    if (dp[i - 1][j] >= wuliNums[i]) {
////                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
////                    }
////                    dp[i][j + moneyNums[i]] = Math.max(dp[i][j + moneyNums[i]], dp[i - 1][j] + wuliNums[i]);
////                }
////            }
////        }
////        int ans = -1;
////        for(int j = 1; j<N*2; ++j){
////            if(dp[n-1][j]>-1){
////                ans = j;
////                break;
////            }
////        }
////        System.out.println(ans);
//    }
}
