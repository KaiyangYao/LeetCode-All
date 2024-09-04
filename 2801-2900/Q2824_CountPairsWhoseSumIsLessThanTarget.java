import java.util.*;

/**
 * 排序 + 双指针
 * 
 * O(n logn) time | O(log n) space for sorting
 */
class Solution2824 {
  public int countPairs(List<Integer> nums, int target) {
      Collections.sort(nums);

      int left = 0;
      int right = nums.size() - 1;
      int ans = 0;

      while (left < right) {
          if (nums.get(left) + nums.get(right) >= target) {
              right -= 1;
          } else {
              ans += right - left;
              left += 1;
          }
      }

      return ans;
  }
}