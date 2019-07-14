package NiuKeLeetCode;

import java.util.ArrayList;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */
public class SumN {
    public ArrayList<ArrayList<Integer>> sumN(int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int min = 1;
        int max = 2;
        while(min < max && min < target/2){
            int sum = 0;
            for(int i = min; i<=max;i++){
                sum += i;
            }
            if(sum < target){
                max++;
            }else if(sum > target){
                min++;
            }else{
                ArrayList<Integer> tmp = new ArrayList<>();
                for(int i = min; i<=max;i++){
                    tmp.add(i);
                }
                ans.add(tmp);
                min++;
                max++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SumN sumN = new SumN();
        System.out.println(sumN.sumN(100));
    }

}
