package zyp.swordoffer;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author zyp
 */
public class PrintMinNumber {

    public String PrintMinNumber2(int [] numbers){
        ArrayList<Integer> list = new ArrayList<>();
        for(int x:numbers){
            list.add(x);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) { //o2是list相对前面的值 o1是list相对后面的值
                String a = o1+""+o2;
                String b = o2+""+o1;
                return a.compareTo(b); //如果a大于b为真
            }
        });

        StringBuilder str = new StringBuilder();
        for(int x:list){
            str.append(x);
        }
        System.out.println(str.toString());
        return  str.toString();

    }






    String min = String.valueOf(Long.MAX_VALUE);
    ArrayList<String > curMin = new ArrayList<>();
    public String PrintMinNumber(int [] numbers) {
//       permutation(numbers,0);
        ANN(numbers,numbers.length,numbers.length);
        System.out.println(min);
       return  min;
    }

    public  void ANN(int[] numbers,int m,int n){
        if(m==0 || curMin.size() == n){
            String cur = StringUtils.join(curMin,"");
            min = Long.parseLong(cur)<Long.parseLong(min)?cur:min;
            return;
        }
        for(int i =0;i<numbers.length;i++){
            if(curMin.contains(String.valueOf(numbers[i]))){
                continue;
            }
            curMin.add(String.valueOf(numbers[i]));
            ANN(numbers,m-1,n);
            curMin.remove(curMin.size()-1);
        }
    }


    public void permutation(int[] numbers,int i){
        if(i==numbers.length-1){
            String cur ="";
            for(int x:numbers){
                cur += String.valueOf(x);
            }
            min = Long.parseLong(cur)<Long.parseLong(min)?cur:min;
            return;
        }
        for(int j = i;j<numbers.length;j++){
            swap(numbers,i,j);
            permutation(numbers,i+1);
            swap(numbers,i,j);
        }
    }

    public void swap(int[] array,int i,int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        PrintMinNumber pm = new PrintMinNumber();
        int[] a ={3334,3,3333332};
        pm.PrintMinNumber2(a);
    }
}
