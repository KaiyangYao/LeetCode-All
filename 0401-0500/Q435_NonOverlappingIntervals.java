import java.util.*;

/**
 * Greedy
 * 
 * 2023/07/04
 * 
 * Similar: 452
 */

/**
 * O(n logn) time | O(log n) space
 */
class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return Integer.compare(interval1[1], interval2[1]);
            }
        });

        int currEnd = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= currEnd) {
                currEnd = intervals[i][1];
                count++;
            }
        }

        return intervals.length - count;
    }
}