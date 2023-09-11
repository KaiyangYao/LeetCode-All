/**
 * Binary Search
 * 2023/09/10
 */

/**
 * O(log n) time | O(1) space
 * 二分index
 */
class Solution275 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (n - mid <= citations[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }
}