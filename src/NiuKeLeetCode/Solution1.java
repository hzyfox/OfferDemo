package NiuKeLeetCode;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int i = input.length() - 1;
        for (; i >= 0; i--) {
            if (input.charAt(i) == ';') {
                break;
            }
        }
        String[] numStrs = input.substring(0, i).split(",");
        int N = Integer.valueOf(input.substring(i + 1));
        int[] nums = new int[numStrs.length];
        i = 0;
        for (String e : numStrs) {
            nums[i++] = Integer.valueOf(e);
        }

        PriorityQueue<Integer> bigHeap = new PriorityQueue<Integer>(
                (a, b) -> {
                    if (a % 2 == 0 && b % 2 == 0) {
                        return b - a;
                    }
                    if (a % 2 == 1 && b % 2 == 1) {
                        return b - a;
                    }
                    if (a % 2 == 0 && b % 2 == 1) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
        );
        for (int e : nums) {
            bigHeap.offer(e);
        }
        for (int j = 0; j < N; j++) {
            if (j != N - 1) {
                System.out.print(bigHeap.poll());
                System.out.print(",");
            } else {
                System.out.println(bigHeap.poll());
            }
        }
    }
}
