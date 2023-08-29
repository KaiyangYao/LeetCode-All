import java.util.*;

/**
 * Dijkstra
 * 
 * 2023/07/17
 */

 /**
  * O(mlogn) time | O(m) space
  */
class Solution1514 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<double[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double weight = succProb[i];
            graph[from].add(new double[] {to, weight});
            graph[to].add(new double[] {from, weight});
        }

        double[] prob = new double[n];
        Arrays.fill(prob, 0.0);
        prob[start_node] = 1.0;

        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new double[] {start_node, 1.0});
        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            int currNode = (int) curr[0];
            double p = curr[1];
            if (currNode == end_node) {
                return p;
            }
            if (p < prob[currNode]) continue;
            for (double[] neighbor : graph[currNode]) {
                int nextNode = (int) neighbor[0];
                double newP = p * neighbor[1];
                if (newP > prob[nextNode]) {
                    prob[nextNode] = newP;
                    pq.offer(new double[] {nextNode, newP});
                }
            }
        }

        return 0.0;
    }
}