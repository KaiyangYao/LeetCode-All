/**
 * 2023/08/30
 */

/**
 * Solution 1: O(n) time | O(n) space
 */
class Solution334_01 {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        leftMin[0] = nums[0];
        rightMax[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }
        for (int i = 0; i < n; i++) {
            if (leftMin[i] < nums[i] && nums[i] < rightMax[i]) {
                return true;
            }
        }

        return false;
    }
}

/**
 * Solution 2: O(n) time | O(1) space
 * 
 * See Leetcode official explanation
 */
class Solution334_02 {
    public boolean increasingTriplet(int[] nums) {
        int left = nums[0];
        int mid = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int right = nums[i];
            if (right > mid) {
                return true;
            } else if (right > left) {
                mid = right;
            } else {
                left = right;
            }
        }

        return false;
    }
}