package swordoffer;

import java.util.HashMap;
import java.util.HashSet;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class Duplicate {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        HashSet<Integer> store = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (!store.contains(numbers[i])) {
                store.add(i);
            } else {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    public boolean duplicate0(int[] numbers, int length, int[] duplication) {
        for (int i = 0; i < length; i++) {
            int index = numbers[i];
            if (index < 0) {
                index = numbers[i] + length;
            }
            if (numbers[index] < 0) {
                duplication[0] = numbers[i] < 0 ? numbers[i] + length : numbers[i];
                return true;
            } else {
                numbers[index] -= length;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {2,1,3,1,4};
        int[] result = new int[1];
        System.out.println(new Duplicate().duplicate0(array,array.length,result));
        System.out.println(result[0]);
    }
}
