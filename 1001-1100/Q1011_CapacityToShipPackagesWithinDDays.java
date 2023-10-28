/**
 * Binary Search
 * 2023/10/27
 * Same as Q410!
 */

/**
 * O(n logn) time
 * O(1) space
 */
class Solution1011 {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        for (int w : weights) {
            sum += w;
        }

        int left = 1, right = sum;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(weights, mid, days)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isValid(int[] weights, int num, int days) {
        int day = 1;
        int total = 0;
        for (int w : weights) {
            if (w > num) {
                return false;
            }
            if (total + w <= num) {
                total += w;
            } else {
                day += 1;
                total = w;
            }
        }
        return day <= days;
    }
}