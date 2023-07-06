/**
 * [4, 3, 2, 6]
 * F(0) = 0*4 + 1*3 + 2*2 + 3*6
 * F(1) = 0*6 + 1*4 + 2*3 + 3*2
 *      = F(0) + sum - 4*6
 *      = F(0) + sum - n * nums[n-i];
 */

/**
 * Math
 * 
 * 2023/07/6
 */

/**
 * O(n) time | O(1) space
 */
class Solution396 {
    public int maxRotateFunction(int[] nums) {
        int prev = 0;
        int sum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            prev += i * nums[i];
            sum += nums[i];
        }

        int max = prev;
        for (int i = 1; i < n; i++) {
            prev = prev + sum - n * nums[n - i];
            max = Math.max(max, prev);
        }

        return max;
    }
}