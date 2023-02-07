/*
 * len(nus) = n
 * O(n) time | O(1) space
 * 
 * 2023/02/04
 * 
 * Almost same as #1493
 */
class Solution487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int zeroCount = 0;
        int ans = 0;
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

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}