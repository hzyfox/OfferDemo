package zyp.swordoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zyp
 */
public class MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int count = 0;
        int maxValue = 0;
        int maxCount = 0;
        Arrays.sort(array);
        count++;
        int i=1;
        for(;i<array.length;i++){
            if(array[i-1]==array[i]){
                count++;
            }else {
                maxCount = Math.max(count,maxCount);
                maxValue = maxCount>count?maxValue:array[i-1];
                count = 1;
            }
        }
        maxCount = Math.max(count,maxCount);
        maxValue = maxCount>count?maxValue:array[i-1];
        maxValue = maxCount*2>array.length?maxValue:0;
        System.out.println(maxValue);
        return maxValue;
    }

    public int MoreThanHalfNum_Solution_Copy(int[] array){
        int count = 1;
        int maxValue = array[0];
        for(int i = 1;i<array.length;i++){
            if(count==0){
                maxValue = array[i];
                count =1;
            }
            if(array[i-1]==array[i]){
                count++;
            }else{
                count--;
            }
        }
        count =0;
        for(int i=0;i<array.length;i++){
            if(array[i] == maxValue){
                count++;
            }
        }
        return count*2>array.length?maxValue:0;
    }

    public static void main(String[] args) {
        MoreThanHalfNum_Solution moreThanHalfNum_solution = new MoreThanHalfNum_Solution();
        int[] a = {1,2,3,3,4,5,5,5};
        moreThanHalfNum_solution.MoreThanHalfNum_Solution(a);
    }
}
