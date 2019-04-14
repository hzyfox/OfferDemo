package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * create with leetcode
 * USER: husterfox
 */
public class Coins {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10};
        int m = 20;
        int[] ans = new int[m + 1];
        ArrayList<ArrayList<Integer>> store = new ArrayList<>(21);
        ArrayList<Integer> initial = new ArrayList<>();
        store.add(initial);
        int target = 20;
        calculateCoins(ans, coins, target, 1, store);
        int i = 0;
        for (int num : ans) {
            System.out.format("凑齐%d元 至少需要: %d, 需要的具体硬币是： %s \n", i, ans[i], store.get(i++));
        }
        ArrayList<Integer> finalAns = new ArrayList<>();
        rangeCoin(coins, 20, finalAns);
        System.out.printf("凑齐%d-%d元 需要%d个硬币，分别是: %s\n", 1, 20, finalAns.size(), finalAns);


    }

    public static void rangeCoin(int[] coins, int target, ArrayList<Integer> store) {
        int sum = 0;
        for (int i = 1; i <= target; i++) {
            if (i > sum) {
                for (int j = coins.length - 1; j >= 0; j--) {
                    if (coins[j] <= i) {
                        sum += coins[j];
                        store.add(coins[j]);
                        break;
                    }
                }
                //i>sum 说明缺1
                if (i > sum) {
                    System.out.println("can't do that...");
                    break;
                }
            }
        }
    }

    public static void calculateCoins(int[] ans, int[] coins, int target, int curr, ArrayList<ArrayList<Integer>> store) {
        if (curr > target) {
            return;
        }
        int min = 999999;
        int i = 0;
        for (int coin : coins) {
            if (curr - coin >= 0) {
                if (ans[curr - coin] + 1 < min) {
                    i = coin;
                    min = ans[curr - coin] + 1;
                }
            }
        }
        ArrayList<Integer> newlist = (ArrayList<Integer>) store.get(curr - i).clone();
        newlist.add(i);
        store.add(newlist);
        ans[curr] = min;
        calculateCoins(ans, coins, target, curr + 1, store);
    }

}
