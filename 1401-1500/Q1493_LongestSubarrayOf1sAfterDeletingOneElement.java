/*
 * len(nus) = n
 * O(n) time | O(1) space
 * 
 * 2023/02/04
 * 
 * Almost same as #487
 */
class Solution1493 {
    public int longestSubarray(int[] nums) {
        int zeroCount = 0;
        int result = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            result = Math.max(result, right - left);  // 注意这里不+1，因为0要删除
        }
        return result;
    }
}