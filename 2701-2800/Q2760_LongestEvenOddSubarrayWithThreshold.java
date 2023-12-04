/**
 * 分组循环
 * 2023/11/28
 */

/**
 * O(n) time
 * O(1) space
 */
class Solution2760 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int ans = 0;
        int i = 0;
        while (i < n) {
            if (nums[i] > threshold || nums[i] % 2 != 0) {
                i++;
                continue;
            }
            int j;
            for (j = i + 1; j < n; j++) {
                if (nums[j] > threshold || nums[j] % 2 == nums[j - 1] % 2) {
                    break;
                }
            }

            ans = Math.max(ans, j - i);
            i = j;
        }

        return ans;
    }
}