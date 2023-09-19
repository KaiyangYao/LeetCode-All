import java.util.*;

/**
 * Backtracking
 * 2023/09/15
 */

/**
 * O(n*2^n) + O(n log n)time (每个数可以选择选或不选 + 排序时间)
 * O(target) + O(log n) space (最多有target数量长度的栈空间 + 排序空间)
 */
class Solution040 {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(int[] candidates, int target, int sum, List<Integer> currList, int start) {
        if (sum == target) {
            result.add(new ArrayList<>(currList));
            return;
        } else if (sum > target) {
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i != start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                currList.add(candidates[i]);
                dfs(candidates, target, sum + candidates[i], currList, i + 1);
                currList.remove(currList.size() - 1);
            }
        }
    }
}