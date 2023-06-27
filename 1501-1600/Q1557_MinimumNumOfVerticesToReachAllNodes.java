import java.util.*;

/**
 * Graph Theory (find in degree)
 * 
 * O(m+n) time | O(n) space
 * m = len(edges)
 * 
 * 2023/06/26
 */
class Solution1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inDegree = new int[n];
        for (int i = 0; i < edges.size(); i++) {
            List<Integer> curr = edges.get(i);
            inDegree[curr.get(1)]++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                result.add(i);
            }
        }

        return result;
    }
}