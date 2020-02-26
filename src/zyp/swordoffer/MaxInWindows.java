package zyp.swordoffer;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @author zyp
 */
public class MaxInWindows {
    public static void main(String[] args) {
        MaxInWindows maxInWindows = new MaxInWindows();
        int[] nums = {2,3,4,2,6,2,5,1};
        maxInWindows.maxInWindows(nums,3);
    }
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if(size==0){
            return res;
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>(); //用来存储数据的下标
        int begin = 0;
        for (int i = 0;i< num.length;i++){
            begin = i-size+1;
            if(deque.size()==0){
                deque.addLast(i);
            }else {
                if(begin > deque.peekFirst()){
                    deque.pollFirst();
                }
                while (deque.size()>0&&num[deque.peekLast()]<=num[i]){
                    deque.pollLast();
                }
                deque.addLast(i);
            }
            if(begin>=0){
                res.add(num[deque.peekFirst()]);
            }
        }
        return res;
    }
}
