import java.util.*;

/**
 * Topological Sort 模板题
 * 
 * 2023/06/27
 */

 /**
  * O(n+m) time | O(n+m) space
  */
class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            List<Integer> list = new ArrayList<>();
            edges.add(list);
        }

        for (int[] pre: prerequisites) {
            edges.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;
            for (int x: edges.get(curr)) {
                inDegree[x]--;
                if (inDegree[x] == 0) {
                    q.offer(x);
                }
            }
        }

        return count == numCourses;
    }
}