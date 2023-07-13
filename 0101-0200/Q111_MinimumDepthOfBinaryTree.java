import java.util.*;

/*
 * O(n) time
 * O(height) space for dfs,  O(n) space for bfs(#queue)
 * 
 * 2023/07/10
 */
class Solution104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
     * dfs / recursive
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        else if (root.left == null) return minDepth(root.right) + 1;
        else if (root.right == null) return minDepth(root.left) + 1;
        else return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    /*
     * bfs / iterative, queue
     */
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int layer = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode next = q.poll();
                if (next.left == null && next.right == null) {
                    return layer + 1;
                }
                if (next.left != null) q.offer(next.left);
                if (next.right != null) q.offer(next.right);
            }
            layer++;
        }
        return -1;
    }
}