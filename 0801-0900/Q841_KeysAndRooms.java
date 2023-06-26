import java.util.*;

/**
 * Graph
 * 
 * 2023/06/13
 */

/**
 * DFS
 * 
 * O(n + m) time  (其中 n 是图中的点数，m 是图中的边数)
 * O(n) space  (visited 数组，递归栈的开销都是n)
 */
class Solution841_01 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        int count = dfs(rooms, visited, 0);
        return count == n;
    }

    private int dfs(List<List<Integer>> rooms, boolean[] visited, int curr) {
        int count = 0;
        if (!visited[curr]) {
            visited[curr] = true;
            count++;
            List<Integer> keys = rooms.get(curr);
            for (int x : keys) {
                count += dfs(rooms, visited, x);
            }
        }
        return count;
    }
}

/**
 * BFS
 * 
 * O(n + m) time  (其中 n 是图中的点数，m 是图中的边数)
 * O(n) space  (visited 数组，queue的开销都是n)
 */
class Solution841_02 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        int count = 1;
        visited[0] = true;
        while (!queue.isEmpty()) {
            List<Integer> keys = rooms.get(queue.poll());
            for (int i = 0; i < keys.size(); i++) {
                int x = keys.get(i);
                if (!visited[x]) {
                    visited[x] = true;
                    count++;
                    queue.offer(x);
                }
            }
        }

        return count == n;
    }
}