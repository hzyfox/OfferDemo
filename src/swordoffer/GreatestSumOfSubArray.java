package swordoffer;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class GreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        int max = array[0];
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum += array[i];
            sum = Math.max(sum, array[i]);
            max = Math.max(sum, max);
        }

        return max;

    }

    public static void main(String[] args) {
        int[] array = {6,-3,-2,7,-15,1,2,2};
        System.out.println(new GreatestSumOfSubArray().FindGreatestSumOfSubArray(array));
    }
}
