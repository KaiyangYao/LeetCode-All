/**
 * Two Pointer
 * 
 * 2023/07/23 CN Daily
 */

/**
 * O(n) time | O(1) space
 * 装水取决于小边。如果leftSum - rightSum，则最小边肯定由leftSum决定，所以可以直接更新
 */
class Solution042_01 {
    public int trap(int[] height) {
        int n = height.length;
        int leftSum = 0;
        int rightSum = 0;
        int l = 0, r = n - 1;
        int ans = 0;

        while (l <= r) {
            leftSum = Math.max(leftSum, height[l]);
            rightSum = Math.max(rightSum, height[r]);
            if (leftSum < rightSum) {
                ans += leftSum - height[l];
                l++;
            } else {
                ans += rightSum - height[r];
                r--;
            }
        }

        return ans;
    }
}

/**
 * O(n) time | O(n) space
 */
class Solution042_02 {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

        leftSum[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftSum[i] = Math.max(leftSum[i - 1], height[i]);
        }
        rightSum[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] = Math.max(rightSum[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftSum[i], rightSum[i]) - height[i];
        }
        return ans;
    }
}