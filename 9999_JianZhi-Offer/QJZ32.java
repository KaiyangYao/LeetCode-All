import java.util.*;

/*
 * 剑指 Offer 32. 从上到下打印二叉树
 * 
 * I. 层序遍历 (一维数组)
 * O(n) time | O(n) space
 * 
 * II. 层序遍历 (二维数组)
 * O(n) time | O(n) space
 * Same as LeetCode #102
 * 
 * II. 之字形层序遍历 (二维数组)
 * LinkedList -> 偶数 addLast(), 奇数 addFirst()
 * O(n) time | O(n) space
 * 
 * 
 * 2023/01/29
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class QJZ32_01 {
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            result.add(curr.val);
            if (curr.left != null)
                queue.offer(curr.left);
            if (curr.right != null)
                queue.offer(curr.right);
        }

        int[] resArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            resArr[i] = result.get(i);
        return resArr;
    }
}

class QJZ32_02 {
    // Iteration
    public List<List<Integer>> levelOrderI(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if (curr.left != null)
                    queue.offer(curr.left);
                if (curr.right != null)
                    queue.offer(curr.right);
            }
            result.add(level);
        }

        return result;
    }

    // Recursion
    private List<List<Integer>> ret;

    public List<List<Integer>> levelOrderII(TreeNode root) {
        ret = new ArrayList<>();
        dfs(0, root);
        return ret;
    }

    private void dfs(int depth, TreeNode root) {
        if (root == null) {
            return;
        }
        // 当二维数组的元素个数等于层数的时候，说明该层没有对应的数组来储存数据，于是add一个
        if (ret.size() == depth) {
            ret.add(new ArrayList<>());
        }
        ret.get(depth).add(root.val);
        dfs(depth + 1, root.left);
        dfs(depth + 1, root.right);
    }
}


class QJZ32_03 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();
                if (result.size() % 2 == 0) {
                    level.addLast(curr.val);
                } else {
                    level.addFirst(curr.val);
                }
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            result.add(level);
        }
        return result;
    }
}