package jvm.heap;

import java.util.Random;

/**
 * create with jvm.heap
 * USER: husterfox
 */

public class ParallelScavengeHeapExample {
    public static void main(String[] args) {
        Random random = new Random();
        int[] intArray = new int[102400];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = random.nextInt();
        }
        for (int i = 0; i< 10; i++){
            System.out.println(intArray[i]);
        }
    }
}
