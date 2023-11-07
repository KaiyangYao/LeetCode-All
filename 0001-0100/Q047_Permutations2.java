import java.util.*;

/**
 * Backtrack
 * 2023/11/01
 */

 // 先排序。如果两个数相等，之前的一个数没有选上，则这个数也不能选!
class Solution047 {
    List<List<Integer>> result;
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, new HashSet<Integer>(), new ArrayList<Integer>());
        return result;
    }

    private void dfs(int[] nums, Set<Integer> set, List<Integer> currList) {
        int n = nums.length;
        if (currList.size() == n) {
            result.add(new ArrayList<>(currList));
        }
        for (int i = 0; i < n; i++) {
            if (set.contains(i)) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !set.contains(i - 1)) {
                continue;
            }

            used[i] = true;
            set.add(i);
            currList.add(nums[i]);

            dfs(nums, set, currList);

            used[i] = false;
            set.remove(i);
            currList.remove(currList.size() - 1);
        }
    }
}