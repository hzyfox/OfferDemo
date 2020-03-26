package zyp.swordoffer;

import java.util.ArrayList;

/**
 * @author zyp
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
         ArrayList<ArrayList<Integer>> result = new ArrayList<>();
         int low = 1,high = 2;
         while (low<high){
             int curSum = (low+high)*(high-low+1)/2;
             if(curSum==sum){
                 ArrayList<Integer> tmp = new ArrayList<>();
                 for(int i = low;i<=high;i++){
                     tmp.add(i);
                 }
                 result.add(tmp);
                 low++;
             }else if(curSum<sum){
                 high++;
             }else{
                 low++;
             }
         }
         return result;
    }

    public static void main(String[] args) {
        FindContinuousSequence fc = new FindContinuousSequence();
        ArrayList<ArrayList<Integer>>  result =fc.FindContinuousSequence(10);
        for(int i = 0;i<result.size();i++){
            for(int j = 0;j<result.get(i).size();j++){
                System.out.println(result.get(i).get(j));
            }
        }
    }
}
