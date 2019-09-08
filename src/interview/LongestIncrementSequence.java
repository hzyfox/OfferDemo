package interview;

import java.util.ArrayList;

/**
 * 最长递增子区间
 */
public class LongestIncrementSequence {

    public static int dynamicProgram(int[] arr) {
        //dp[i] 表示以i 结尾的 最长的长度
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i]) {
                    dp[i] = Math.max(Math.max(dp[i], dp[j] + 1),1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }

    public static int insert(int[] arr) {
        ArrayList<Integer> tail = new ArrayList<>();
        tail.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            replace(tail, arr[i]);
        }
        return tail.size();
    }

    public static void replace(ArrayList<Integer> tail, int target) {
        if (target >= tail.get(tail.size() - 1)) {
            tail.add(target);
        } else {
            int s = 0;
            int e = tail.size() - 1;
            int mid = 0;
            while (s <= e) {
                mid = (s + e) / 2;
                if (tail.get(mid) <= target) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
            tail.set(s, target);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        System.out.println(dynamicProgram(arr));
    }
}
