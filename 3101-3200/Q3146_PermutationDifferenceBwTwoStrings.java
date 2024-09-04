/**
 * O(n) time | O(n) space
 */
class Solution3146 {
  public int findPermutationDifference(String s, String t) {
      int[] count = new int[26];
      for (int i = 0; i < s.length(); i++) {
          count[s.charAt(i) - 'a'] = i;
      }

      int ans = 0;
      for (int i = 0; i < t.length(); i++) {
          ans += Math.abs(i - count[t.charAt(i) - 'a']);
      }

      return ans;
  }
}