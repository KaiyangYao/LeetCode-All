import java.util.*;

/**
 * 2023/07/07
 */

/**
 * O(n logn) time | O(log n) space
 */
class Solution976 {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i] && nums[i] - nums[i - 1] < nums[i - 2]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }
}