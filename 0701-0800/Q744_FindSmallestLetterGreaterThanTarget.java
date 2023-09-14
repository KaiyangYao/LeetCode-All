/**
 * Binary Search
 * 2023/09/11
 */

/**
 * O(log n) time | O(1) space
 */
class Solution744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                right = mid - 1;
            } else if (letters[mid] <= target) {
                left = mid + 1;
            }
        }
        return left < letters.length ? letters[left] : letters[0];
    }
}