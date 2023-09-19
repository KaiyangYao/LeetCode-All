import java.util.*;

/**
 * DP 模板题
 * 2023/09/18
 */

/**
 * Solution 1: DP解法
 * 函数定义: `dp[i]` 表示以 `nums[i]` 这个数结尾的最长递增子序列的长度。
 * base case: `dp[i] = 1` , 因为以 `nums[i]` 结尾的最长递增子序列起码要包含它自己。
 */

/**
 * O(n^2) time | O(n) space
 */
class Solution300_01 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i < n; i++) {
            int prevMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    prevMax = Math.max(prevMax, dp[j]);
                }
            }
            dp[i] += prevMax;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}

/**
 * Solution 2: 贪心
 * 考虑一个简单的贪心，如果我们要使上升子序列尽可能的长，则我们需要让序列上升得尽可能慢，
 * 因此我们希望每次在上升子序列最后加上的那个数尽可能的小。
 */

/**
 * O(n log n) time
 * O(n) space
 * Q354: 俄罗斯信封套娃
 */
class Solution300_02 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int d = 0;
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > dp[d]) {
                d++;
                dp[d] = nums[i];
            } else {
                int left = 0, right = d;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (nums[i] > dp[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                dp[left] = nums[i];
            }
        }

        return d + 1;
    }        
}