import java.util.*;

/**
 * BFS
 * 2023/11/08
 */

/**
 * O(n) time | O(n) space
 */
class Solution1377 {
    class Pair {
        int node;
        double prob;

        public Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

    public double frogPosition(int n, int[][] edges, int t, int target) {
        if (edges.length == 0) {
            return 1.0;
        }

        List<List<Integer>> tree = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            tree.get(edges[i][0]).add(edges[i][1]);
            tree.get(edges[i][1]).add(edges[i][0]);
        }
        tree.get(1).add(1);

        Set<Integer> visited = new HashSet<>();
        Deque<Pair> queue = new ArrayDeque<>();
        int time = 0;

        visited.add(1);
        queue.offer(new Pair(1, 1.0));

        while (!queue.isEmpty()) {
            time += 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair currPair = queue.poll();
                int curr = currPair.node;
                double currProb = currPair.prob;
                List<Integer> neighbors = tree.get(curr);
                double newProb = 1.0 / (neighbors.size() - 1);
                for (int neighbor : neighbors) {
                    if (visited.contains(neighbor)) {
                        continue;
                    }
                    if (neighbor == target) {
                        return (time < t && tree.get(neighbor).size() == 1) || (time == t) ? currProb * newProb : 0.0;
                    }
                    queue.offer(new Pair(neighbor, currProb * newProb));
                    visited.add(neighbor);
                }
            }
        }

        return 0.0;
    }
}