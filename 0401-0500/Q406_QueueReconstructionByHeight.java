import java.util.*;

/**
 * Overwrite compare
 * 
 * 2023/07/04
 * 
 */

/**
 * O(n log n + n^2) = O(n^2) time [result.add takes n^2]
 * O(log n + n) = O(log n) space
 */
class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : b[0] - a[0]);
        List<int[]> result = new ArrayList<>();
        for (int[] x : people) {
            result.add(x[1], x);
        }
        return result.toArray(new int[people.length][]);
    }
}