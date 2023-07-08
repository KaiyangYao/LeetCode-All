import java.util.*;

/**
 * 2023/07/08
 */

/**
 * O(n) time | O(1) space
 */
class Solution2551 {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        for (int i = 0; i < n - 1; i++) {
            weights[i] += weights[i + 1];
        }
        Arrays.sort(weights, 0, n - 1);

        long maxSum = 0, minSum = 0;
        for (int i = 0; i < k - 1; i++) {
            minSum += weights[i];
            maxSum += weights[n - 2 - i];
        }
        return maxSum - minSum;
    }
}