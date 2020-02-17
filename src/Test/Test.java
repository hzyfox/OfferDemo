package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zyp
 */
public  class Test {

    public int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        if(arr==null||arr.length==0){
            return max;
        }
        for(int x:arr){
            max = Math.max(max,x);
        }
        return max;
    }

    public int addToN(int n){
        if(n==1){
            return 1;
        }
        return addToN(n-1)+n;
    }


    public int fiBo(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fiBo(n-1)+fiBo(n-2);
    }


    public int fibo(int n){
        int[] array=new int[n];
        if(n==0){
            array[0] = 0;
        }
        if(n==1){
            array[1] =1;
        }
        for(int i=2;i<=n;i++){
            array[i] = array[i-1]+array[i-2];
        }
        return array[n-1];
    }






    static int flag = 0;
    public static void add(int flag){
        flag = flag +1;
    }
    public static void main(String[] args) {



    }
}
