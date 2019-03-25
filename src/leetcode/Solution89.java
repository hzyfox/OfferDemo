package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution89 {
    public List<Integer> grayCode(int n) {
        LinkedList<Integer> ans = new LinkedList<>();
        ans.add(0);
        if (n == 0) {
            return ans;
        }
        ans.add(1);
        for (int i = 1; i < n; i++) {
            int size = ans.size();
            while (size > 0) {
                ans.add(ans.get(--size) ^ (1 << i));
            }
        }
        return ans;
    }
}
