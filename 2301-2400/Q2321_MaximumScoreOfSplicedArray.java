/**
 * DP, 最大子数组和
 * 2023/07/20
 * 
 * sum1 - (nums1[left] + ... + nums1[right]) + (nums2[left] + ... + nums2[right])
 * = sum1 + (nums2[left] - nums1[left]) + ... + (nums2[right] - nums1[right])
 * = sum1 + diff[left] + ... + diff[right]
 * 
 * 只需找到diff数组最大子数组和 (变成53题)
 */

/**
 * O(n) time | O(1) space
 */
class Solution2321 {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(findMax(nums1, nums2), findMax(nums2, nums1));
    }

    private int findMax(int[] nums1, int[] nums2) {
        int currMax = 0;
        int globalMax = currMax;
        int sum1 = 0;
        for (int i = 0; i < nums1.length; i++) {
            sum1 += nums1[i];
            int diff = nums2[i] - nums1[i];
            currMax = Math.max(currMax + diff, 0);
            globalMax = Math.max(currMax, globalMax);
        }
        return sum1 + globalMax;
    }
}