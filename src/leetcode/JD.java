package leetcode;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * create with leetcode
 * USER: husterfox
 */
public class JD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        ArrayList<ArrayList<Integer>> map = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n - 1; i++) {
            int key = scanner.nextInt();
            int value = scanner.nextInt();
            map.get(key).add(value);
            map.get(value).add(key);
        }
        boolean[] viewed = new boolean[n + 1];
        viewed[1] = true;
        int res = 0;
        for (int elem : map.get(1)) {
            LinkedList<Integer> queue = new LinkedList<>();
            int cnt = 1;
            queue.offer(elem);
            viewed[elem] = true;
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int elem0 : map.get(node)) {
                    if (!viewed[elem0]) {
                        viewed[elem0] = true;
                        queue.offer(elem0);
                        cnt++;
                    }
                }
            }
            res = Math.max(res, cnt);
        }
        System.out.println(res);
    }
}
