/**
 * DP
 * 
 * 2023/07/23 CN Daily
 */

/**
 * O(n) time | O(n) space
 */
class Solution042 {
    public int trap(int[] height) {
        int n = height.length;
        int[] preMax = new int[n];
        int[] postMax = new int[n];
        preMax[0] = height[0];
        postMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], height[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            postMax[i] = Math.max(postMax[i + 1], height[i]);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.min(preMax[i], postMax[i]) - height[i];
        }

        return sum;
    }
}