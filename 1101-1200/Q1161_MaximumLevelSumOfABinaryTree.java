import java.util.*;

/**
 * Binary Tree + BFS with size
 * 2023/09/04
 */

/**
 * O(n) time | O(n) space
 */
class Solution1161 {
    public int maxLevelSum(TreeNode root) {
        int maxSum = root.val;
        int maxLevel = 1;
        int levelCount = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            levelCount++;
            int size = q.size();
            int currSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                currSum += curr.val;
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
            if (currSum > maxSum) {
                maxSum = currSum;
                maxLevel = levelCount;
            }
        }

        return maxLevel;
    }
}