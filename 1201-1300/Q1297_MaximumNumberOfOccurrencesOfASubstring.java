import java.util.*;

/* 
 * 20240905
 * 定长滑动窗口
 * 
 * O(n) time | O(n) space
 * 
 * 本题只需统计长度为minSize的子串，而不需要统计长度为maxSize的子串。
 * Why? "abc" 肯定会覆盖 a，ab， 即长的肯定会覆盖短的，只要考虑最短的就好。
 * 
*/

class Solution1297 {
  public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
    Map<Character, Integer> charMap = new HashMap<>();
    Map<String, Integer> ansMap = new HashMap<>();
    int max = 0;
    int n = s.length();

    for (int i = 0; i < minSize; i++) {
      char c = s.charAt(i);
      charMap.put(c, charMap.getOrDefault(c, 0) + 1);
    }

    if (charMap.size() <= maxLetters) {
      ansMap.put(s.substring(0, minSize), 1);
      max = 1;
    }

    for (int i = minSize; i < n; i++) {
      char right = s.charAt(i);
      char left = s.charAt(i - minSize);
      String curr = s.substring(i - minSize + 1, i + 1);
      charMap.put(right, charMap.getOrDefault(right, 0) + 1);
      charMap.put(left, charMap.get(left) - 1);
      if (charMap.get(left) == 0) {
        charMap.remove(left);
      }

      if (charMap.size() <= maxLetters) {
        ansMap.put(curr, ansMap.getOrDefault(curr, 0) + 1);
        max = Math.max(max, ansMap.get(curr));
      }
    }

    return max;
  }
}