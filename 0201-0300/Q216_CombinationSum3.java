import java.util.*;

/**
 * Back Tracking
 * 2023/09/15
 */
class Solution216 {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        dfs(1, k, 0, n, 0, new ArrayList<>());
        return result;
    }

    private void dfs(int start, int k, int currCount, int n, int sum, List<Integer> currList) {
        if (currCount == k) {
            if (sum == n) {
                result.add(new ArrayList<>(currList));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            currList.add(i);
            dfs(i + 1, k, currCount + 1, n, sum + i, currList);
            currList.remove(currList.size() - 1);
        }
    }
}