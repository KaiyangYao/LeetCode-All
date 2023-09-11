import java.util.*;
/**
 * Binary Tree
 * 2023/09/03
 */

/**
 * Method 1: double DFS
 * O(n^2) time | O(n) space
 */
class Solution437_01 {
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        dfs1(root, targetSum);
        return count;
    }

    private void dfs1(TreeNode root, long targetSum) {
        if (root == null)
            return;
        dfs2(root, targetSum);
        dfs1(root.left, targetSum);
        dfs1(root.right, targetSum);
    }

    private void dfs2(TreeNode root, long targetSum) {
        if (root == null)
            return;
        if (root.val == targetSum) {
            count++;
        }
        dfs2(root.left, targetSum - root.val);
        dfs2(root.right, targetSum - root.val);
    }
}

/**
 * Method 2:
 * Prefix Sum + HashMap
 * Similar: Q560, Q930
 */

/**
 * O(n) time | O(n) space
 */
class Solution437_02 {
    int count = 0;
    Map<Long, Integer> map;

    public int pathSum(TreeNode root, int targetSum) {
        map = new HashMap<>();
        map.put(0L, 1);
        dfs(root, targetSum, 0);
        return count;
    }

    private void dfs(TreeNode root, int targetSum, long preSum) {
        if (root == null)
            return;
        long currSum = preSum += root.val;
        if (map.containsKey(currSum - targetSum)) {
            count += map.get(currSum - targetSum);
        }
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        dfs(root.left, targetSum, currSum);
        dfs(root.right, targetSum, currSum);
        map.put(currSum, map.get(currSum) - 1);
        if (map.get(currSum) == 0) {
            map.remove(currSum);
        }
    }
}