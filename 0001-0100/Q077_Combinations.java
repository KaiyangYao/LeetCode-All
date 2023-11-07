import java.util.*;

/**
 * Backtracking
 * 2023/09/15
 */
class Solution077 {
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        dfs(1, n, k, new ArrayList<>());
        return result;
    }

    private void dfs(int start, int n, int k, List<Integer> currList) {
        if (currList.size() == k) {
            result.add(new ArrayList(currList));
            return;
        }

        // 剪枝
        if ((k - currList.size() > (n - start + 1))) {
            return;
        }

        for (int i = start; i <= n; i++) {
            currList.add(i);
            dfs(i + 1, n, k, currList);
            currList.remove(currList.size() - 1);
        }
    }
}