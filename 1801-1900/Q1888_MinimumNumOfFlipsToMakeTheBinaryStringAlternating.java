/* 
 * 20240905
 * 定长滑动窗口
 * 
 * O(n) time | O(1) space
 * 
*/
class Solution1888 {
  public int minFlips(String s) {
      int ans;
      int cnt = 0;
      int n = s.length();
      char[] s01 = "01".toCharArray();

      for (int i = 0; i < n; i++) {
          if (s.charAt(i) != s01[i % 2]) {
              cnt++;
          }
      }

      ans = Math.min(cnt, n - cnt);

      for (int i = n; i < n * 2; i++) {
          if (s.charAt(i % n) != s01[i % 2]) {
              cnt++;
          }
          if (s.charAt(i - n) != s01[(i - n) % 2]) {
              cnt--;
          }
          ans = Math.min(ans, Math.min(cnt, n - cnt));
      }

      return ans;
  }
}