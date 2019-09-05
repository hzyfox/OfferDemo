package interview;

import java.util.ArrayList;

/**
 * 组合数问题
 */
public class Permutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        boolean[] flag =new boolean[arr.length];
        dfs(ans, tmp, flag, 2, arr);
        System.out.println(ans);
        System.out.println(ans.size());
    }

    public static void dfs(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> tmp, boolean[] flag, int num, int[] arr){
        if(tmp.size() == num){
            ArrayList<Integer> copy = (ArrayList<Integer>)tmp.clone();
            ans.add(copy);
            return;
        }
        for(int i = 0; i< arr.length; i++){
            if(!flag[i]){
                flag[i] = true;
                tmp.add(arr[i]);
                dfs(ans, tmp, flag, num, arr);
                flag[i] = false;
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
