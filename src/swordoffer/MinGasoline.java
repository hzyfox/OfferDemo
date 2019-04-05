package swordoffer;

import java.util.*;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class MinGasoline {
    public int minGasoline(int distance, int[] distOfGS, int[] allowedGasoline, int initialGasoline) {
        //Key值存放 可以到达的加油站, value值存放到达该加油站后的汽油数(包括在该汽油站加的油)
        HashMap<Integer, Integer> reached = new HashMap<>();
        //将终点站也包含进数组
        int[] distOfGS0 = Arrays.copyOfRange(distOfGS, 0, distOfGS.length + 1);
        distOfGS0[distOfGS0.length - 1] = distance;
        //将终点站也包含进加油范围
        int[] allowedGasoline0 = Arrays.copyOfRange(allowedGasoline, 0, allowedGasoline.length + 1);

        //初始化，从起点出发可以到达的加油站点，以及对应的汽油数
        for (int i = 0; i < distOfGS0.length; i++) {
            if (initialGasoline >= distOfGS0[i]) {
                reached.put(i, initialGasoline - distOfGS[i] + allowedGasoline0[i]);
            } else {
                break;
            }
        }
        int target = distOfGS0.length - 1;
        int minTimes = 0;
        if (reached.containsKey(target)) {
            return minTimes;
        }

        //遍历reached的每个节点，将可以到达的下一个加油站的下标和对应的汽油数加入toAdd
        //注意reached可能有多个节点可以到达toAdd中的同一个点，我们这个时候选择所携带汽油最多的加进来。
        //最后将toAdd 赋值给 reached 完成一次迭代。
        while (!reached.isEmpty()) {
            if (reached.containsKey(target)) {
                return minTimes;
            }
            HashMap<Integer, Integer> toAdd = new HashMap<>();
            for (int index : reached.keySet()) {
                int tmpGasoline = reached.get(index);
                for (int i = index + 1; i < distOfGS0.length; i++) {
                    if (tmpGasoline >= (distOfGS0[i] - distOfGS0[index])) {
                        int gasoline = tmpGasoline - (distOfGS0[i] - distOfGS0[index]) + allowedGasoline0[i];
                        if (toAdd.containsKey(i)) {
                            if (toAdd.get(i) < gasoline) {
                                toAdd.put(i, gasoline);
                            }
                        } else {
                            toAdd.put(i, gasoline);
                        }
                    }
                }
            }
            minTimes++;
            reached = toAdd;
        }
        return -1;
    }

    public int solution(int distance, int currIndex, int targetIndex, int[] distOfGS, int[] allowedGasoline, int initialGasoline) {
        if (currIndex == distOfGS.length) {
            return 0;
        }
        int needGasoline = 0;
        if (currIndex == -1) {
            if (targetIndex == distOfGS.length) {
                if (initialGasoline >= distance) {
                    return 0;
                } else {
                    return -1;
                }
            } else {
                needGasoline = distOfGS[targetIndex];
            }
        } else {
            if (targetIndex == distOfGS.length) {
                if (initialGasoline >= distance - distOfGS[currIndex]) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                needGasoline = distOfGS[targetIndex] - distOfGS[currIndex];
            }
        }

        if (needGasoline > initialGasoline) {
            return -1;
        } else {
            int min = Integer.MAX_VALUE;
            for (int i = targetIndex + 1; i <= distOfGS.length; i++) {
                int tmp = solution(distance, targetIndex, i, distOfGS, allowedGasoline, initialGasoline - needGasoline + allowedGasoline[targetIndex]);
                if (tmp != -1) {
                    min = Math.min(tmp, min);
                }
            }
            if (min == Integer.MAX_VALUE) {
                return -1;
            } else {
                return 1 + min;
            }
        }
    }

    public static void main(String[] args) {
        int[] distOfGS = {5, 7, 8, 10};
        int[] allowedGasoline = {1, 3, 1, 5};
        int distance = 15;
        int initialGasoline = 5;
        System.out.println(new MinGasoline().minGasoline(distance, distOfGS, allowedGasoline, initialGasoline));
    }

    public int minNumberOfProjects(int num, int projCmptDec, int restDec,
                                   int[] errorScore) {
        // WRITE YOUR CODE HERE
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < errorScore.length; i++) {
            queue.offer(errorScore[i]);
        }
        int cnt = 0;
        while (!queue.isEmpty() && queue.peek() > 0) {
            cnt++;
            PriorityQueue<Integer> queue0 = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            int i = 0;
            while (!queue.isEmpty()) {
                if (i == 0) {
                    queue0.add(queue.poll() - projCmptDec);
                    i++;
                } else {
                    queue0.add(queue.poll() - restDec);
                }
            }
            queue = queue0;
        }
        return cnt;
    }


}
