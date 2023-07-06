/**
 * 2023/07/06
 */

 /**
  * O(mn) time | O(n) space
  */
class Solution028 {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        out: for (int i = n; i <= m; i++) {
            String s = haystack.substring(i-n, i);
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) != needle.charAt(j)) continue out;
            }
            return i - n;
        }
        return -1;
    }
}