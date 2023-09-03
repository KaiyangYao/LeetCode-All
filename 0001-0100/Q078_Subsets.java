import java.util.*;

/**
 * Backtrack
 * 2023/09/02
 */

/**
 * O(n* 2^n) time 一共有2^n的状态，每个状态需要O(n)构造子集
 * O(n) space
 */
class Solution078 {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(0, nums, curr);
        return result;
    }

    private void dfs(int i, int[] nums, List<Integer> curr) {
        if (i == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        dfs(i + 1, nums, curr); // 不要当前的
        curr.add(nums[i]);
        dfs(i + 1, nums, curr); // 要当前的
        curr.remove(curr.size() - 1);
    }
}