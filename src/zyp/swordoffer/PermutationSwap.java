package zyp.swordoffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author zyp
 */
public class PermutationSwap {
    public ArrayList<String> Permution(String str){
        ArrayList<String> res = new ArrayList<>();
        if(str.length()>0 && str!=null){
            helper(str.toCharArray(),0,res);
            Collections.sort(res);
        }
        return res;
    }

    public void helper(char[] array,int i,ArrayList<String> list){
        if(i==array.length-1){
            //这里加判断的原因是存在重复字母的情况例如abb
            if(!list.contains(String.valueOf(array))){
                System.out.println(String.valueOf(array));
                list.add(String.valueOf(array));
            }
            return;
        }

        for(int j=i;j<array.length;j++){
            swap(array,i,j);
            helper(array,i+1,list);
            //将数组还原
            swap(array,i,j);
        }
    }

    public void swap(char[] array,int i,int j){
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        PermutationSwap permutationSwap =  new PermutationSwap();
        permutationSwap.Permution("abc");
    }
}
