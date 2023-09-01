import java.util.*;

/**
 * 2023/08/30
 */

/**
 * O(n) time | O(1) space
 */
class Solution1679 {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        int count = 0;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum < k) {
                l++;
            } else if (sum > k) {
                r--;
            } else {
                count++;
                l++;
                r--;
            }
        }

        return count;
    }
}