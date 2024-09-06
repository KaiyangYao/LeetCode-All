import java.util.*;

/* 
 * 20240904
 * 定长滑动窗口
 * 
 * O(n) time | O(n) space
 * 
*/

class Solution2841 {
  public long maxSum(List<Integer> nums, int m, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int n = nums.size();
    long sum = 0;
    long ans = 0;

    for (int i = 0; i < k; i++) {
      sum += nums.get(i);
      map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
    }

    if (map.size() >= m) {
      ans = Math.max(ans, sum);
    }

    for (int i = k; i < n; i++) {
      int right = nums.get(i);
      int left = nums.get(i - k);

      sum = sum + right - left;
      map.put(right, map.getOrDefault(right, 0) + 1);
      map.put(left, map.get(left) - 1);
      if (map.get(left) == 0) {
        map.remove(left);
      }
      left++;

      if (map.size() >= m) {
        ans = Math.max(ans, sum);
      }
    }

    return ans;
  }
}