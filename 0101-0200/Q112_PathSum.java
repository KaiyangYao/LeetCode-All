import java.util.*;
/*
 * 0/1. DFS recursion
 * 2. Iteration with stack (two stacks) [DFS]
 * 3. Iteration with queue (two queues) [BFS]
 * 
 * 
 * O(n) time (每个node最多被访问了0次)
 * O(n) space
 * 
 * 2023/02/07
 * 2023/09/02
 */
class Solution112_00 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (targetSum == root.val && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}

class Solution112_01 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    private boolean dfs(TreeNode node, int targetSum, int currSum) {
        if (node == null) {
            return false;
        }

        if (currSum + node.val == targetSum && node.left == null && node.right == null) {
            return true;
        }

        return dfs(node.left, targetSum, currSum + node.val) ||
                dfs(node.right, targetSum, currSum + node.val);
    }
}

// Stack 迭代 (DFS)
// 注意需要两个栈，因为需要sum val
class Solution112_02 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> nodeVal = new ArrayDeque<>();
        stack.push(root);
        nodeVal.push(root.val);

        while (!stack.isEmpty()) {
            int n = stack.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = stack.pop();
                int val = nodeVal.pop();
                if (node.left == null && node.right == null && val == targetSum) {
                    return true;
                }

                // 先右后左，这样左边先出
                if (node.right != null) {
                    stack.push(node.right);
                    nodeVal.push(node.right.val + val);
                }

                if (node.left != null) {
                    stack.push(node.left);
                    nodeVal.push(node.left.val + val);
                }
            }
        }
        return false;
    }
}

// Queue 迭代 (BFS)
// 注意需要两个队列，因为需要sum val
class Solution112_03 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<Integer> nodeVal = new ArrayDeque<>();
        queue.offer(root);
        nodeVal.offer(root.val);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                int val = nodeVal.poll();
                if (node.left == null && node.right == null && val == targetSum) {
                    return true;
                }

                // Queue 先左后右，这样左边先出
                if (node.left != null) {
                    queue.offer(node.left);
                    nodeVal.offer(node.left.val + val);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                    nodeVal.offer(node.right.val + val);
                }
            }
        }
        return false;
    }
}