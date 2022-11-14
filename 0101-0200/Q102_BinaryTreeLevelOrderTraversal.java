import java.util.*;

/*
 * BFS 模板题：层序遍历！
 * 
 * O(n) time | O(n) space
 * 
 * 2022/11/11
 */
 class Solution102 {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        
        if (root != null) {
            queue.offer(root);
        }
        
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            answer.add(level);
        }
        
        return answer;
    }
}