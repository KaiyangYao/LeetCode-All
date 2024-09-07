/**
 * 20240905
 * 
 * 不定长滑动窗口
 * 
 * O(n) time
 * O(1) space
 */
class Solution2730 {
  public int longestSemiRepetitiveSubstring(String s) {
    int n = s.length();
    int lastSamePt = -1;
    int ans = 0;

    for (int l = 0, r = 0; r < n; r++) {
      if (r > 0 && s.charAt(r) == s.charAt(r - 1)) {
        l = lastSamePt + 1;
        lastSamePt = r - 1;

      }

      ans = Math.max(ans, r - l + 1);
    }

    return ans;
  }
}