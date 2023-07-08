import java.util.*;

/**
 * Sliding Window 模板题
 * 
 * 2023/07/08
 */

/**
 * O(n) time | O(1) space
 */
class Solution159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > 2) {
                char leftC = s.charAt(l);
                map.put(leftC, map.get(leftC) - 1);
                if (map.get(leftC) == 0) {
                    map.remove(leftC);
                }
                l++;
            }
            result = Math.max(result, r - l + 1);
        }
        return result;
    }
}