import java.util.*;

/*
 * Method 1: recursion   O(n)time, O(n)space [recursion stack]
 * Method 2: iterative
 * 
 * 2022/11/09
 */
class Solution589 {
    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    
    private void helper(Node root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        for (Node child: root.children) {
            helper(child, result);
        }
    }
}