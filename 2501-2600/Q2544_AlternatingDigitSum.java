/**
 * 2023/07/12 CN Daily
 */

/**
 * O(log n) time | O(1) space
 */
class Solution2544 {
    public int alternateDigitSum(int n) {
        int sum = 0, sign = 1;
        while (n > 0) {
            sum += sign * (n % 10);
            n /= 10;
            sign = -sign;
        }
        return -sign * sum;
    }
}