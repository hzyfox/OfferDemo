package swordoffer;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<Integer> store = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= (sum + 1) / 2; i++) {
            int cnt = 0;
            for (int j = i; j <= (sum + 1) / 2; j++) {
                store.add(j);
                cnt += j;
                if (cnt == sum) {
                    ans.add((ArrayList<Integer>) store.clone());
                    store.clear();
                    break;
                } else {
                    if (cnt > sum) {
                        store.clear();
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence0(int sum) {
        int lo = 1, hi = 2;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (hi > lo) {
            ArrayList<Integer> store = new ArrayList<>();
            int curr = (hi + lo) * (hi - lo + 1) / 2;
            if (curr == sum) {
                for (int i = lo; i < hi; i++) {
                    store.add(i);
                }
                ans.add(store);
            } else {
                if (curr < sum) {
                    hi++;
                } else {
                    lo++;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new FindContinuousSequence().FindContinuousSequence(100));
    }
}
