import java.util.*;

/**
 * Graph
 * 2023/09/14
 */

class Solution399 {
    class Neighbor {
        String node;
        double weight;
        public Neighbor(String node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Neighbor>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String a = eq.get(0);
            String b = eq.get(1);
            if (!graph.containsKey(a)) {
                graph.put(a, new ArrayList<>());
            }
            if (!graph.containsKey(b)) {
                graph.put(b, new ArrayList<>());
            }
            graph.get(a).add(new Neighbor(b, values[i]));
            graph.get(b).add(new Neighbor(a, 1 / values[i]));
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            ans[i] = getVal(queries.get(i), graph);
        }

        return ans;
    }

    private double getVal(List<String> query, Map<String, List<Neighbor>> graph) {
        String a = query.get(0);
        String b = query.get(1);
        Queue<Neighbor> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        
        q.offer(new Neighbor(a, 1.0));
        while (!q.isEmpty()) {
            Neighbor curr = q.poll();
            visited.add(curr.node);
            if (!graph.containsKey(curr.node)) {
                continue;
            }

            if (curr.node.equals(b)) {
                return curr.weight;
            }

            for (Neighbor n: graph.get(curr.node)) {
                if (visited.contains(n.node)) continue;
                q.offer(new Neighbor(n.node, curr.weight * n.weight));
            }
        }

        return -1.0;
    }
}