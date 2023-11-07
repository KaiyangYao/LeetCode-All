import java.util.*;

/**
 * 树的直径类似问题 (Q104, Q543)
 * 2023/11/06
 */

/**
 * O(n) time | O(n) space
 */
class Solution2246 {
    List<List<Integer>> tree;
    int maxCount = 0;

    public int longestPath(int[] parent, String s) {
        tree = new ArrayList<>();
        for (int i = 0; i < parent.length; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i < parent.length; i++) {
            tree.get(parent[i]).add(i);
        }

        dfs(0, s);
        return maxCount;
    }

    private int dfs(int start, String s) {
        int firstL = 0;
        int secondL = 0;
        List<Integer> neighbors = tree.get(start);
        for (int i = 0; i < neighbors.size(); i++) {
            int currCount = dfs(neighbors.get(i), s);
            if (s.charAt(start) == s.charAt(neighbors.get(i))) {
                continue;
            }
            if (currCount > firstL) {
                secondL = firstL;
                firstL = currCount;
            } else if (currCount > secondL) {
                secondL = currCount;
            }

        }
        maxCount = Math.max(maxCount, firstL + secondL + 1);
        return Math.max(firstL, secondL) + 1;
    }
}