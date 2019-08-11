package NiuKeLeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */
public class CMN {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[] flag = new boolean[5];

        dfs(arr, 0, flag, 3,new ArrayList<>(), ans);
        System.out.println(ans);
    }


    public static void dfs(int[] arr, int start, boolean[] flag, int sum, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> ans) {
        if (tmp.size() == sum) {
            ArrayList<Integer> copy = (ArrayList<Integer>) tmp.clone();
            ans.add(copy);
            return;
        }

        for (int i = start; i < arr.length; i++) {
                tmp.add(arr[i]);
                dfs(arr, i+1, flag, sum, tmp, ans);
                tmp.remove(tmp.size() - 1);
        }
    }
}
