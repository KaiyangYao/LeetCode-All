import java.util.*;

/**
 * BFS
 * 
 * 2023/06/24
 * 
 * O(n) time | O(n) space
 */
class Solution1306 {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>(); // index
        visited[start] = true;
        q.offer(start);
        while (!q.isEmpty()) {
            int currIndex = q.poll();
            if (arr[currIndex] == 0) return true;
            int next1 = currIndex + arr[currIndex];
            int next2 = currIndex - arr[currIndex];
            if (next1 >= 0 && next1 < n && !visited[next1]) {
                if (arr[next1] == 0) return true;
                q.offer(next1);
                visited[next1] = true;
            }
            if (next2 >= 0 && next2 < n && !visited[next2]) {
                if (arr[next2] == 0) return true;
                q.offer(next2);
                visited[next2] = true;
            }
        }
        return false;
    }
}