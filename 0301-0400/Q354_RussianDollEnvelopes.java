import java.util.*;

/**
 * Q300拓展 -- Longest Increasing Substring
 * 2023/09/19
 */

/**
 * O(nlogn) time
 * O(n) space
 * 
 * 为什么h要逆序排序？防止 (1, 3) 和 (1, 4) 算成两个。
 * 即每一个相同的w最多可以有一个h
 */
class Solution354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> (a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]));
        int[] h = new int[envelopes.length];
        for (int i = 0; i < h.length; i++) {
            h[i] = envelopes[i][1];
        }

        return lengthOfLIS(h);
    }

    private int lengthOfLIS(int[] nums) {
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