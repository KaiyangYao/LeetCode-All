/*
 * Sliding Window
 * 
 * len(num) = n
 * O(n) time | O(1) space
 * 
 * 2023/02/04
 * 
 * Similar Questions:
 * #424
 */

 class Solution1004_01 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        int numZeros = 0;
        for (int l = 0, r = 0; r < n; r++) {
            if (nums[r] == 0) {
                numZeros++;
            }
            while (numZeros > k) {
                if (nums[l] == 0) {
                    numZeros--;
                }
                l++;
            }
            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}

/**
 * Discarded
 */
class Solution1004_02 {
    public int longestOnes(int[] nums, int k) {
        int[] counter = new int[2];
        int ans = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            counter[nums[right]]++;
            while (counter[0] > k) {
                counter[nums[left]]--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}