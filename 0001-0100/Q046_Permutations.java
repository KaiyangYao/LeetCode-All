import java.util.*;

/**
 * Backtrack
 * 2023/11/01
 */
class Solution046 {
    List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        dfs(nums, new HashSet<Integer>(), new ArrayList<Integer>());
        return result;
    }

    private void dfs(int[] nums, Set<Integer> set, List<Integer> currList) {
        int n = nums.length;
        if (currList.size() == n) {
            result.add(new ArrayList<>(currList));
        }
        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            currList.add(nums[i]);
            dfs(nums, set, currList);
            set.remove(nums[i]);
            currList.remove(currList.size() - 1);
        }
    }
}