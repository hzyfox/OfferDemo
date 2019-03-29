package swordoffer;

import java.util.ArrayList;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> ans = new ArrayList<>();
        int multiply = Integer.MAX_VALUE;
        for (int i = 0, j = array.length - 1; i < j; ) {
            if (array[i] + array[j] > sum) {
                j--;
            } else {
                if (array[i] + array[j] < sum) {
                    i++;
                } else {
                    ans.add(array[i]);
                    ans.add(array[j]);
                    return ans;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(new FindNumbersWithSum().FindNumbersWithSum(array, 7));
    }
}
