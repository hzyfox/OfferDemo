package swordoffer;

/**
 * create with swordoffer
 * USER: husterfox
 */

import java.util.ArrayList;
import java.util.Scanner;

public class WordChange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.valueOf(scanner.nextLine());
        String[] source = new String[k];
        String[] target = new String[k];
        for (int i = 0; i < k; i++) {
            source[i] = scanner.nextLine();
        }
        for (int i = 0; i < k; i++) {
            target[i] = scanner.nextLine();
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans += minDistance(source[i], target[i]);
        }
        System.out.println(ans);
    }

    public static int minDistance(String source, String target) {
        int sourceLen = source.length();
        int targetLen = target.length();
        int[][] res = new int[sourceLen + 1][targetLen + 1];
        for (int i = 0; i < sourceLen; i++) {
            res[i][0] = i;
        }
        for (int i = 1; i <= targetLen; i++) {
            res[0][i] = i;
        }
        for (int i = 0; i < sourceLen; i++) {
            for (int j = 0; j < targetLen; j++) {
                if (source.charAt(i) == target.charAt(j)) {
                    res[i + 1][j + 1] = res[i][j];
                } else {
                    int a = res[i][j];
                    int b = res[i][j + 1];
                    int c = res[i + 1][j];
                    res[i + 1][j + 1] = (a < b) ? (a < c ? a : c) : (b < c ? b : c);
                    res[i + 1][j + 1]++;
                }
            }
        }
        return res[sourceLen][targetLen];
    }
}
