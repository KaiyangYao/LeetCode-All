/**
 * Sliding Window
 * 
 * 2023/07/06
 */

/**
 * O(n) time | O(1) space
 */
class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;
        for (int j = k; j < nums.length; j++) {
            sum = sum - nums[j - k] + nums[j];
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }
}