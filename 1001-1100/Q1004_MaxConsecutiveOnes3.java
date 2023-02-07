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
class Solution1004 {
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