import java.util.*;

/**
 * Tree Diameter
 * 2023/11/06
 * 
 * Same: Q2246
 */

/**
 * O(n) time | O(n) space
 */
class Solution {
    int ans;

    public int diameter(Node root) {
        ans = 0;
        dfs(root);
        return ans - 1;
    }

    private int dfs(Node root) {
        int firstL = 0, secondL = 0;
        for (Node n : root.children) {
            int currCount = dfs(n);
            if (currCount > firstL) {
                secondL = firstL;
                firstL = currCount;
            } else if (currCount > secondL) {
                secondL = currCount;
            }
        }
        ans = Math.max(ans, firstL + secondL + 1);
        return Math.max(firstL, secondL) + 1;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}