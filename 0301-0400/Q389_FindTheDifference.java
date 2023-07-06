/**
 * 异或运算模板题
 * 
 * a^0 = 0
 * a^a = 0
 * 
 * 2023/06/27
 * 
 * Similar: Q136
 */

 /**
  * O(n) time | O(1) space
  */
class Solution389 {
    public char findTheDifference(String s, String t) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result ^= s.charAt(i);
        }

        for (int j = 0; j < t.length(); j++) {
            result ^= t.charAt(j);
        }

        return (char) result;
    }
}