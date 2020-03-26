package zyp.swordoffer;

import java.util.ArrayList;

/**
 * @author zyp
 */
public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        int[] result = new int[array.length];
        for(int i =0 ;i<array.length;i++){
            if(i==0){
                result[i] = array[i];
                continue;
            }
            if(i>=1&&result[i-1]<0){
                result[i] = array[i];
            }
            if(i>=1&&result[i-1]>0){
                result[i] = result[i-1]+array[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i =0 ;i< result.length;i++){
            max = Math.max(result[i],max);
        }
        System.out.println(max);
        return max;

    }

    public int maxSumOfSubArray(int[] array){
        int maxSum = array[0],tmpSum = array[0];
        for(int i =1;i<array.length;i++){
            tmpSum = tmpSum>0?tmpSum+array[i]:array[i];
            maxSum=maxSum>tmpSum?maxSum:tmpSum;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr =  {1,-2,3,10,-4,7,2,-5};
        FindGreatestSumOfSubArray fin = new FindGreatestSumOfSubArray();
        fin.FindGreatestSumOfSubArray(arr);
    }
}
