package zyp.swordoffer;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author zyp
 */
public class GetMedian {
    //用优先队列，构建两个堆，最大堆和最小堆，默认是最小堆；
    //用最小堆存较小的数据，最大堆存较大的数据，保证最大堆的所有数据都小于最小堆；
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    int count = 0 ;
    public void Insert(Integer num) {
        count++;
        if(count%2!=0){
            max.offer(num);
            min.offer(max.poll());
        }else {
            min.offer(num);
            max.offer(min.poll());
        }
    }

    public Double GetMedian() {
        if(count%2==0){
            return (min.poll()+max.poll())/2.0;
        }else {
            return min.poll()*1.0;
        }
    }
}
