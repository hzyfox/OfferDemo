package swordoffer;

import java.util.ArrayList;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class MaxInWindow {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (size <= 0) {
            return ans;
        }
        int maxIndex = -1;
        int max = -1;
        for (int i = 0; i < num.length - size + 1; i++) {
            if (maxIndex >= i) {
                if (num[i + size - 1] >= max) {
                    max = num[i + size - 1];
                    maxIndex = i + size - 1;
                }
                ans.add(max);
            } else {
                maxIndex = i;
                max = num[i];
                for (int j = i + 1; j < size + i; j++) {
                    if (num[j] >= max) {
                        max = num[j];
                        maxIndex = j;
                    }
                }
                ans.add(max);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] test = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(new MaxInWindow().maxInWindows(test, 3));
    }
}

