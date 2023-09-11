import java.util.*;

/**
 * Binary Tree + BFS with size
 * 2023/09/04
 */

/**
 * O(n) time | O(n) space
 */
class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if (root == null)
            return result;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode curr = null;
            for (int i = 0; i < size; i++) {
                curr = q.poll();
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
            result.add(curr.val);
        }
        return result;
    }
}