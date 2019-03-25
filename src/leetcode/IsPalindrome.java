package leetcode;

import java.util.ArrayList;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class IsPalindrome {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            ArrayList<Integer> store = new ArrayList<>();
            while (x != 0) {
                store.add(x % 10);
                x = x / 10;
            }
            for (int i = 0, j = store.size() - 1; i <= j; i++, j--) {
                if (!store.get(i).equals(store.get(j))) {
                    return false;
                }
            }
            return true;
        }
    }
}
