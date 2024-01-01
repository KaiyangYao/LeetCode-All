import java.util.*;

/**
 * Graph
 * 2023/12/05
 */

/**
 * O(n) time
 * O(n) space
 */
class Solution {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map<Node, Node> map;

    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        return clone(node);
    }

    private Node clone(Node node) {
        if (node == null) {
            return node;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node n = new Node(node.val, new ArrayList<Node>());
        map.put(node, n);
        for (Node neighbor : node.neighbors) {
            n.neighbors.add(clone(neighbor));
        }

        return n;
    }
}