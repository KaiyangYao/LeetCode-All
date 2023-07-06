/**
 * 2023/07/06
 */

/**
 * O(log n) time | O(1) space
 */
class Solution326 {
    public boolean isPowerOfThree(int n) {
        while (n > 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}