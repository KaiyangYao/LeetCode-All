/**
 * 2023/07/06
 */

 /**
  * O(n^2) time | O(1) space
  */
class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        boolean result = false;
        out: for (int i = 1; i * 2 <= n; i++) {
            if (n % i != 0) continue; 
            for (int j = i; j < n; j++) {
                if (s.charAt(j) != s.charAt(j - i)) {
                    continue out;
                }
            }
            result = true;
        }
        return result;
    }
}