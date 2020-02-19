package zyp.swordoffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zyp
 */
public class IsContinuous {
    /**
     * 数组中的最大值和最小值只差要小于5；
     * @param numbers
     * @return
     */
    public boolean isContinuous2(int[] numbers){
        int[] arr = new int[14];
        int min = 14;
        int max = -1;
        boolean flag = true;
        for(int i =0;i<numbers.length;i++){
            if(numbers[i]==0){
                continue;
            }
            arr[numbers[i]]++;
            if(arr[numbers[i]]>1){
                flag = false;
                return flag;
            }
            if(numbers[i]<min){
                min = numbers[i];
            }
            if(numbers[i]>max){
                max = numbers[i];
            }
        }
        System.out.println(min+""+max);
        if(max-min<5){
            flag = true;
        }else {
            flag = false;
        }
        return flag;
    }


    public boolean isContinuous(int [] numbers) {
        if(numbers.length==0){
            return false;
        }
        boolean flag = true;
        Arrays.sort(numbers);
        ArrayList<Integer> king = new ArrayList<>();
        ArrayList<Integer> noKing = new ArrayList<>();
        for(int i = 0;i<numbers.length;i++){
            if(numbers[i]==0){
                king.add(numbers[i]);
            }else {
                noKing.add(numbers[i]);
            }
        }
        for(int i = 1;i<noKing.size();i++){
            int delta = noKing.get(i)-noKing.get(i-1)-1;
            if(delta==0){
                continue;
            } else if(delta<0||delta>king.size()){
                 flag = false;
                 break;
             }else {
                while (delta!=0){
                    king.remove(--delta);
                }
            }
        }
     return flag;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,4,5};
        IsContinuous ic = new IsContinuous();
        ic.isContinuous2(nums);
    }

}
