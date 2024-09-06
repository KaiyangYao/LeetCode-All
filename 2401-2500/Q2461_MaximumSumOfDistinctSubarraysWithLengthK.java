import java.util.*;

/* 
 * 20240904
 * 定长滑动窗口
 * 
 * O(n) time | O(k) space
 * 
*/

class Solution2461 {
  public long maximumSubarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int n = nums.length;
    long sum = 0;
    long ans = 0;

    for (int i = 0; i < k; i++) {
      sum += nums[i];
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }

    if (map.size() == k) {
      ans = Math.max(ans, sum);
    }

    for (int i = k; i < n; i++) {
      int right = nums[i];
      int left = nums[i - k];
      sum += right - left;
      map.put(right, map.getOrDefault(right, 0) + 1);
      map.put(left, map.get(left) - 1);
      if (map.get(left) == 0) {
        map.remove(left);
      }

      if (map.size() == k) {
        ans = Math.max(ans, sum);
      }
    }

    return ans;
  }
}