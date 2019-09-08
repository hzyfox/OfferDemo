package interview;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * 求队列中最大值
 */
public class QueueWithMax {
    private Deque<InternalData> datas = new ArrayDeque<>();
    private Deque<InternalData> maxs = new ArrayDeque<>();
    private int currIndex = 0;

    public void offer(Integer numbers) {
        while (!maxs.isEmpty() && maxs.peekLast().numbers < numbers) {
            maxs.pollLast();
        }
        InternalData tmp = new InternalData(numbers, currIndex);
        datas.offer(tmp);
        maxs.offer(tmp);
        ++currIndex;
    }
    public Integer poll() throws Exception {
        if (datas.isEmpty()) {
            throw new Exception("queue is Empty");
        }
        if (datas.peekFirst().index == maxs.peekFirst().index) {
            maxs.pollFirst();
        }
        return Objects.requireNonNull(datas.pollFirst()).numbers;
    }
    public Integer max() throws Exception {
        if (maxs.isEmpty()) {
            throw new Exception("queue is Empty");
        }
        return maxs.peekFirst().numbers;
    }
    private class InternalData {
        Integer numbers;
        int index;

        InternalData(Integer numbers, int index) {
            this.numbers = numbers;
            this.index = index;
        }
    }
}
