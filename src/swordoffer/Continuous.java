package swordoffer;

import java.util.Arrays;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class Continuous {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        Arrays.sort(numbers);
        int zeroCnt = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                zeroCnt++;
            } else {
                for (i = i + 1; i < numbers.length; i++) {
                    if (numbers[i] - numbers[i - 1] == 1) {
                        continue;
                    } else {
                        if (numbers[i] == numbers[i - 1]) {
                            return false;
                        }
                        if (zeroCnt > 0 && numbers[i] - numbers[i - 1] - 1 <= zeroCnt) {
                            zeroCnt -= (numbers[i] - numbers[i - 1] - 1);
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = {0, 0, 8, 10, 12};
        System.out.println(new Continuous().isContinuous(array));
    }
}
