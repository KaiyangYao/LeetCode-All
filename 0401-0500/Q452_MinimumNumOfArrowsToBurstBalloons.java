import java.util.*;

/**
 * Greedy
 * 
 * 2023/07/04
 * 
 * Similar: 435
 */

/**
 * /**
 * O(n logn) time | O(log n) space
 */
class Solution452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1;
        int currEnd = points[0][1];
        for (int[] x : points) {
            if (x[0] > currEnd) {
                count++;
                currEnd = x[1];
            }
        }
        return count;
    }
}