package zyp.swordoffer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author zyp
 */
public class FindNumbersWithSum {

    /**
     * 两个数相差越远，乘积越小；另外数组是递增的
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum2(int [] array, int sum) {
        int i = 0,j=array.length-1;
        ArrayList<Integer> result = new ArrayList<>();
        while (i<j){
            if(array[i]+array[j]==sum){
                result.add(array[i]);
                result.add(array[j]);
                break;
            }
            while (i<j&&array[i]+array[j]>sum){
                j--;
            }
            while (i<j&&array[i]+array[j]<sum){
                i++;
            }
        }
        return result;
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int tmp1=Integer.MAX_VALUE,tmp2=Integer.MAX_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<array.length;i++){
            if(!map.containsValue(sum-array[i])){
                map.put(i,array[i]);
            }else{
                int x1 = array[i];
                int x2 = sum-array[i];
                if(result.size()==0){
                    result.add(Math.min(x1,x2));
                    result.add(Math.max(x1,x2));
                }else{
                    if(x1*x2<result.get(0)*result.get(1)){
                        while (result.size()!=0){
                            result.remove(result.size()-1);
                        }
                        result.add(Math.min(x1,x2));
                        result.add(Math.max(x1,x2));
                    }
                }

            }
        }
        System.out.println(result.get(0)+result.get(1));
        return result;
    }





    public static void main(String[] args) {
        int[] arr = {1,2,4,7,11,15};
        FindNumbersWithSum fn = new FindNumbersWithSum();
        fn.FindNumbersWithSum(arr,15);
    }

}
