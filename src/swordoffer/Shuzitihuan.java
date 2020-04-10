package swordoffer;

import java.util.Scanner;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class Shuzitihuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nums = scanner.nextLine();
        boolean negFlag = false;
        String rep = scanner.nextLine();
        String[] repstrs = rep.split(" ");
        if (nums.charAt(0) == '-') {
            nums = nums.substring(1);
            negFlag = true;
        }
        StringBuilder ans = new StringBuilder(nums);
        for (int i = 0; i < nums.length(); i++) {
            ans.replace(i, i + 1, repstrs[nums.charAt(i) - '0' - 1]);
        }
        if (negFlag) {
            System.out.println("-" + ans.toString());
        } else {
            System.out.println(ans.toString());
        }
    }
}
