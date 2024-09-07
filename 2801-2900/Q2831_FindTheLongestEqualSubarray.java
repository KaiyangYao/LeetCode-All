import java.util.*;

/**
 * 20240905
 * 
 * 不定长滑动窗口
 * 
 * O(n) time | O(n) space
 */

class Solution2831 {
  public int longestEqualSubarray(List<Integer> nums, int k) {
      int n = nums.size();
      @SuppressWarnings("unchecked")
      List<Integer>[] posList = new ArrayList[n + 1];
      Arrays.setAll(posList, i -> new ArrayList<>());

      for (int i = 0; i < n; i++) {
          posList[nums.get(i)].add(i);
      }

      int ans = 0;
      for (int i = 0; i < n + 1; i++) {
          List<Integer> currList = posList[i];
          int len = currList.size();
          if (len < ans) continue;

          for (int l = 0, r = 0; r < len; r++) {
              while ((currList.get(r) - currList.get(l) + 1) - (r - l + 1) > k) {
                  l++;
              }
              ans = Math.max(ans, r - l + 1);
          }
      }

      return ans;
  }
}