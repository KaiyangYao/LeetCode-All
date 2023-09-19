import java.util.*;

/**
 * Backtraching
 * 2023/09/15
 */

/**
 * O(n*2^n) time (每个数可以选择选或不选)
 * O(target) space (最多有target数量长度的栈空间)
 */
class Solution039 {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        dfs(candidates, target, new ArrayList<>(), 0, 0);
        return result;
    }

    private void dfs(int[] candidates, int target, List<Integer> curr, int currSum, int currIndex) {
        if (currSum == target) {
            result.add(new ArrayList<>(curr));
            return;
        } else if (currSum > target) {
            return;
        } else {
            for (int i = currIndex; i < candidates.length; i++) {
                curr.add(candidates[i]);
                dfs(candidates, target, curr, currSum + candidates[i], i);
                curr.remove(curr.size() - 1);
            }
        }
    }
}