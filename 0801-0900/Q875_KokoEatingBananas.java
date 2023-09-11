/**
 * Binary Search
 * 2023/09/10
 */

/**
 * O(n log m) time | O(1) space
 * 其中 n 是数组 piles 的长度，m 是数组 piles 中的最大值。
 */
class Solution875 {
    public int minEatingSpeed(int[] piles, int h) {
        int maxValue = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > maxValue) {
                maxValue = piles[i];
            }
        }
        int left = 1, right = maxValue;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (findHours(mid, piles) <= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private long findHours(int k, int[] piles) {
        long count = 0;
        for (int p : piles) {
            count += (p / k) + (p % k == 0 ? 0 : 1);
        }
        return count;
    }
}