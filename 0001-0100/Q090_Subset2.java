import java.util.*;

/**
 * Backtrack
 * 2023/09/02
 */

/**
 * O(n* 2^n) time
 * O(n) space
 */
class Solution090 {
    Set<List<Integer>> result;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result = new HashSet<>();
        List<Integer> curr = new ArrayList<>();
        dfs(0, nums, curr);
        return new ArrayList<>(result);
    }

    private void dfs(int i, int[] nums, List<Integer> curr) {
        if (i == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        dfs(i + 1, nums, curr);
        curr.add(nums[i]);
        dfs(i + 1, nums, curr);
        curr.remove(curr.size() - 1);
    }
}