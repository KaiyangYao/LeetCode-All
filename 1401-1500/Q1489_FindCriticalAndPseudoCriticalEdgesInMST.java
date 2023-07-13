import java.util.*;

/**
 * 2023/07/12
 * 
 * Kruskal + Minimum Spanning Tree
 */

class Solution1489 {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            edgeList.add(new Edge(i, edges[i][0], edges[i][1], edges[i][2]));
        }
        
        int minWeight = calMSTWeight(edgeList, n, null);

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());

        List<Edge> tempEdges = new ArrayList<>(edgeList);
        for (Edge e: edgeList) {
            tempEdges.remove(e);
            if (calMSTWeight(tempEdges, n, null) != minWeight) {
                result.get(0).add(e.id);
            }
            tempEdges.add(e);
        }

        for (Edge e: edgeList) {
            if (result.get(0).contains(e.id)) continue;
            if (calMSTWeight(tempEdges, n, e) == minWeight) {
                result.get(1).add(e.id);
            }
        }

        return result;
    }

    private int calMSTWeight(List<Edge> edgeList, int n, Edge edge) {
        edgeList.sort((a, b) -> Integer.compare(a.weight, b.weight));
        
        UnionFind uf = new UnionFind(n);
        int weight = 0;
        int count = 0;

        if (edge != null) {
            uf.union(edge.start, edge.end);
            count++;
            weight += edge.weight;
        }

        for (int i = 0; i < edgeList.size(); i++) {
            Edge e = edgeList.get(i);
            if (!uf.isConnected(e.start, e.end)) {
                uf.union(e.start, e.end);
                weight += e.weight;
                count++;

                if (count == n - 1) {
                    return weight;
                }
            }
        }
        return weight;
    }

    private class Edge {
        int id, start, end, weight;
        public Edge(int id, int start, int end, int weight) {
            this.id = id;
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    private class UnionFind {
        int parents[];

        public UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        private int find(int x) {
            while (x != parents[x]) {
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return x;
        }

        private void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            parents[rootX] = rootY;
        }

        private boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

    }
}