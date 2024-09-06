/* 
 * 20240905
 * 多重定长滑动窗口
 * 
 * O(n * 26^2) time | O(26) space
 * 
*/
class Solution2953 {
  public int countCompleteSubstrings(String word, int k) {
      int n = word.length();
      int i = 0;
      int ans = 0;

      while (i < n) {
          int j;
          for (j = i + 1; j < n; j++) {
              if (Math.abs(word.charAt(j) - word.charAt(j - 1)) > 2) {
                  break;
              }
          }
          ans += validate(word.substring(i, j), k);
          i = j;
      }

      return ans;
  }

  private int validate(String word, int k) {
      int n = word.length();
      int ans = 0;
      for (int m = 1; m <= 26 && m * k <= n; m++) {
          int[] counter = new int[26];

          for (int r = 0; r < m * k - 1; r++) {
              counter[word.charAt(r) - 'a']++;
          }

          for (int r = m * k - 1; r < n; r++) {
              counter[word.charAt(r) - 'a']++;
              int l = r - (m * k - 1);
              boolean ok = true;

              for (int i = 0; i < 26; i++) {
                  if (counter[i] > 0 && counter[i] != k) {
                      ok = false;
                      break;
                  }
              }
              if (ok) {
                  ans += 1;
              }
              counter[word.charAt(l) - 'a']--;
          }
      }

      return ans;
  }
}