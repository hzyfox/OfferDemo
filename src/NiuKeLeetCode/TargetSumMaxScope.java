package NiuKeLeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */
public class TargetSumMaxScope {
    public static int targetSumMaxScope(int[] datas, int target) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(-1);
        map.put(0, queue);
        for (int i = 0; i < datas.length; i++) {
            sum += datas[i];
            if (map.containsKey(sum - target)) {
                ans = Math.max(ans, i - map.get(sum - target).peek());
                PriorityQueue<Integer> tmp = map.getOrDefault(sum, new PriorityQueue<Integer>());
                tmp.add(i);
                map.put(sum, tmp);
            } else {
                PriorityQueue<Integer> tmp = map.getOrDefault(sum, new PriorityQueue<Integer>());
                tmp.add(i);
                map.put(sum, tmp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] datas = {1, 2, 3, 1, 1, 2, 2, 0};
        System.out.println(targetSumMaxScope(datas, 6));
    }
}
