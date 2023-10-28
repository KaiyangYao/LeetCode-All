/**
 * Binary Search
 * 2023/10/28
 */

/**
 * O(n logn) time
 * O(1) space
 */
class Solution1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long) m * k > (long) n) {
            return -1;
        }

        int left = Integer.MAX_VALUE, right = 0;
        for (int d : bloomDay) {
            left = Math.min(left, d);
            right = Math.max(right, d);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (feasible(bloomDay, m, k, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean feasible(int[] bloomDay, int m, int k, int day) {
        int count = 0;
        int x = 0;
        for (int i = 0; i < bloomDay.length && count < m; i++) {
            if (bloomDay[i] <= day) {
                x++;
                if (x == k) {
                    count++;
                    x = 0;
                }
            } else {
                x = 0;
            }
        }
        return count >= m;
    }
}
