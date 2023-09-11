/**
 * Binary Search
 * 2023/09/10
 */

/**
 * O(log n) time | O(1) space
 */
class Solution069 {
    public int mySqrt(int x) {
        int left = 0, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}