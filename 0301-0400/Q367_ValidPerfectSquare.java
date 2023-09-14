/**
 * Binary Search
 * 2023/09/11
 */

/**
 * O(log n) time | O(1) space
 */
class Solution367 {
    public boolean isPerfectSquare(int num) {
        int left = 0, right = num / 2 + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            if (square == num) {
                return true;
            } else if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            }
        }
        return false;
    }
}