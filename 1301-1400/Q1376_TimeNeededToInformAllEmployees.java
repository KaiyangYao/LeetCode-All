import java.util.*;

/**
 * Graph
 * 
 * 2023/06/18
 */

 /**
  * 建图 + DFS
  * 
  * O(n) time | O(n) space
  */
class Solution1376_01 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(manager[i], new ArrayList<>());
            map.get(manager[i]).add(i);
        }
        return dfs(headID, informTime, map);
    }

    private int dfs(int curr, int[] informTime, Map<Integer, List<Integer>> map) {
        if(map.get(curr) == null || map.get(curr).size() == 0) {
            return 0;
        }

        int time = 0;
        for (int x: map.get(curr)) {
            time = Math.max(time, dfs(x, informTime, map));
        }
        return informTime[curr] + time;
    }
}


/**
 * BFS (Queue)
 * 
 * O(n) time | O(n) space
 */
class Solution1376_02 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(manager[i], new ArrayList<>());
            map.get(manager[i]).add(i);
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        int time = 0;
        queue.offer(new int[]{headID, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (!map.containsKey(curr[0])) {
                time = Math.max(time, curr[1]);
            } else {
                for (int x: map.get(curr[0])) {
                    queue.offer(new int[]{x, curr[1] + informTime[curr[0]]});
                }
            }
        }

        return time;
    }
}