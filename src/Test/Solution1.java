package Test;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * create with Test
 * USER: husterfox
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.valueOf(scanner.nextLine());
        String[] priceStr = scanner.nextLine().split(" ");
        int[] prices = new int[num];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = Integer.valueOf(priceStr[i]);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>();
        for (int elem : prices) {
            priorityQueue.offer(elem);
            priorityQueue1.offer(elem);
        }
        long ans = 0;

        while (priorityQueue.size() >= 3) {
            ans += priorityQueue.poll();
            ans += priorityQueue.poll();
            priorityQueue.poll();
        }

        while(!priorityQueue.isEmpty()){
            ans += priorityQueue.poll();
        }
        System.out.println(ans);
    }
}
