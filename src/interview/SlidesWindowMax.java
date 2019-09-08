package interview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * 滑动窗口的最大值
 */
public class SlidesWindowMax {
    public static ArrayList<Integer> windowMax(int[] datas, int windowSize) {
        ArrayList<Integer> ans = new ArrayList<>();
        //头部存放最大值下标
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < datas.length; i++) {
            while (!queue.isEmpty() && i - queue.peekFirst() >= windowSize) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && datas[queue.peekLast()] < datas[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= windowSize - 1) {
                ans.add(datas[queue.peekFirst()]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] datas = {5, 6, 4, 3, 2, 1};
        System.out.println(windowMax(datas, 3));
    }
}
