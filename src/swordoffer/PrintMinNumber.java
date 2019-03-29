package swordoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class PrintMinNumber {
    public String PrintMinNumber(int[] numbers) {
        String[] input = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            input[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(input, (o1, o2) -> {
            String a = o1.concat(o2);
            String b = o2.concat(o1);
            return a.compareTo(b);
        });
        StringBuilder builder = new StringBuilder();
        for (String s : input) {
            builder.append(s);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        int[] arrays = {3, 32, 321};
        System.out.println(new PrintMinNumber().PrintMinNumber(arrays));
    }
}
