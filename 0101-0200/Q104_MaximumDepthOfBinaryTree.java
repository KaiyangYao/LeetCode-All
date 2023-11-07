import java.util.*;

/*
 * O(n) time
 * O(height) space for dfs,  O(n) space for bfs(#queue)
 * 
 * 2022/11/13
 * Similar: Q543
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
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = maxDepth1(root.left);
        int rightHeight = maxDepth1(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // dfs simplified
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
    }

    /*
     * bfs / iterative, queue
     */
    public int maxDepth3(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            depth++;
        }
        
        return depth;
    }
}