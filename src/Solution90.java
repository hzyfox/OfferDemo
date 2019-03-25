import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<Integer> store = new LinkedList<>();
        for (int i = 1; i <= nums.length; i++) {
            dfs(nums, ans, store, 0, i);
        }

        ans.add(new LinkedList<>());
        return ans;
    }

    public void dfs(int[] nums, List<List<Integer>> ans, LinkedList<Integer> store, int pos, int target) {
        if (target == 0) {
            ans.add((LinkedList<Integer>) store.clone());
            return;
        }
        for (int i = pos; i < nums.length && nums.length - i >= target; i++) {
            store.add(nums[i]);
            dfs(nums, ans, store, pos + 1, target - 1);
            store.remove(store.size() - 1);
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,2};
        System.out.println(new Solution90().subsetsWithDup(array));
    }
}
