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
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        int count = 1;
        visited[0] = true;
        while (!q.isEmpty()) {
            int currRoom = q.poll();
            for (int key : rooms.get(currRoom)) {
                if (!visited[key]) {
                    count++;
                    q.offer(key);
                    visited[key] = true;
                }
            }
        }
        return count == n;
    }
}