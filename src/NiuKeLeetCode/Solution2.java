package NiuKeLeetCode;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int count = 0;

        PriorityQueue<Pair> bigHeap = new PriorityQueue<Pair>((a, b) -> {
            return (b.y * b.x - a.y * a.x);
        });

        for (int i = 1; i <= n; i++) {
            bigHeap.offer(new Pair(i, m));
        }
        int r, c;
        while (!bigHeap.isEmpty()) {
            r = bigHeap.peek().x;
            c = bigHeap.peek().y;
            bigHeap.poll();
            if (--k == 0) {
                System.out.println(r * c);
                break;
            }
            if (c > 1) {
                bigHeap.offer(new Pair(r, c - 1));
            }
        }

    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
