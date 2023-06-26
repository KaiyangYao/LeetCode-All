import java.util.*;

/**
 * Graph
 * 
 * 2023/06/17
 * 
 * 时间复杂度：O(n+r+b)，其中 n 是节点数，r 是红色边的数目，b 是蓝色边的数目。广度优先搜索最多访问一个节点两次，最多访问一条边一次，因此时间复杂度为 O(n+r+b)
 * 空间复杂度：O(n+r+b)。队列中最多有 2n 个元素，保存 next 需要 O(r+b) 的空间，保存 dist 需要 O(n) 的空间。
 */
class Solution1129 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[][] data = new List[2][n];
        for (int r = 0; r < 2; r++) {
            for (int c = 0; c < n; c++) {
                data[r][c] = new ArrayList<>();
            }
        }

        for (int[] edge: redEdges) {
            data[0][edge[0]].add(edge[1]);
        }

        for (int[] edge: blueEdges) {
            data[1][edge[0]].add(edge[1]);
        }

        int[][] dist = new int[2][n];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        // 到达0位置的路径始终为0
        dist[0][0] = 0;
        dist[1][0] = 0;

        // 两种初始路线 0是可达位置 1 是否蓝色
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int v = pair[0], color = pair[1];
            for (int y: data[1-color][v]) {
                if (dist[1-color][y] != Integer.MAX_VALUE) {
                    // 已经超过了这个点
                    continue;
                }
                dist[1-color][y] = dist[color][v] + 1;
                queue.offer(new int[]{y, 1-color});
            }
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            //又两种颜色分别进行广度优先搜索拿到的距离取其最短的那一种
            answer[i] = Math.min(dist[0][i], dist[1][i]);
            //如果没有可达路线 就是-1
            if (answer[i] == Integer.MAX_VALUE) {
                answer[i] = -1;
            }
        }
        return answer;
    }
}