package leetcode;

import java.util.Scanner;

/**
 * create with leetcode
 * USER: husterfox
 */
public class PDD2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String A = in.nextLine();
        String B = in.nextLine();
        int[][] ans = new int[B.length() + 1][A.length() + 1];
        ans[0][0] = 0;
        for (int i = 0; i <= A.length(); i++) {
            ans[0][i] = i;
        }
        for (int i = 0; i <= B.length(); i++) {
            ans[i][0] = i;
        }
        for (int i = 1; i <= B.length(); i++) {
            for (int j = 1; j <= A.length(); j++) {
                int a = Math.min(ans[i - 1][j] + 1, ans[i][j - 1] + 1);
                int b = A.charAt(j - 1) == B.charAt(i - 1) ? ans[i - 1][j - 1] : ans[i - 1][j - 1] + 1;
                ans[i][j] = Math.min(a, b);
            }
        }
        System.out.println(ans[B.length()][A.length()]);
    }
}
