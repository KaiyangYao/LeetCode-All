/**
 * 20240905
 * 
 * 不定长滑动窗口
 * 
 * O(n) time | O(1) space
 * 
 * 正难则反，转换成标准滑动窗口！
 */


class Solution2516 {
  public int takeCharacters(String s, int k) {
      int[] counter = new int[3];
      int n = s.length();
      int maxA, maxB, maxC = 0;
      int ans = -1;

      for (int i = 0; i < n; i++) {
          counter[s.charAt(i) - 'a']++;
      }
      if (counter[0] < k || counter[1] < k || counter[2] < k) {
          return -1;
      }
      maxA = counter[0] - k;
      maxB = counter[1] - k;
      maxC = counter[2] - k;
      counter = new int[3];

      for (int l = 0, r = 0; r < n; r++) {
          counter[s.charAt(r) - 'a']++;
          while (counter[0] > maxA || counter[1] > maxB || counter[2] > maxC) {
              counter[s.charAt(l) - 'a']--;
              l++;
          }
          ans = Math.max(ans, r - l + 1);
      }

      return n - ans;
  }
}