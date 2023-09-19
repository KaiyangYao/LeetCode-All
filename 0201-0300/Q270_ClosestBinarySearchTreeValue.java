/**
 * 2023/09/11
 */


/**
 * Solution 1: Binary Search
 * O(log n) time | O(1) space
 */
class Solution {
    public int closestValue(TreeNode root, double target) {
        double diff = Math.abs(root.val - target);
        int ans = root.val;
        while (root != null) {
            double currDiff = Math.abs(root.val - target);
            if (currDiff < diff || (currDiff == diff && root.val < ans)) {
                diff = currDiff;
                ans = root.val;
            }

            root = root.val < target ? root.right : root.left;
        }
        return ans;
    }
}

/**
 * Solution 2: In order traversal
 * O(n) time | O(n) space
 */
class Solution270_02 {
    double min = Double.MAX_VALUE;
    int ans = 0;

    public int closestValue(TreeNode root, double target) {
        dfs(root, target);
        return ans;
    }

    public void dfs(TreeNode root, double target) {
        if (root == null)
            return;

        dfs(root.left, target);

        if (Math.abs(root.val - target) < min) {
            ans = root.val;
            min = Math.abs(root.val - target);
        }

        dfs(root.right, target);
    }
}