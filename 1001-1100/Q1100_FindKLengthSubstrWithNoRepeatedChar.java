import java.util.*;

/**
 * 固定长度滑动窗口
 * 
 * 2023/07/08
 */

/**
 * O(n) time | O(k) space
 */
class Solution1101 {
    public int numKLenSubstrNoRepeats(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        if (k > s.length())
            return 0;
        for (int i = 0; i < k; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = map.size() == k ? 1 : 0;
        int left = 0;
        for (int right = k; right < s.length(); right++) {
            char rChar = s.charAt(right);
            char lChar = s.charAt(left);
            map.put(rChar, map.getOrDefault(rChar, 0) + 1);
            map.put(lChar, map.get(lChar) - 1);
            if (map.get(lChar) == 0) {
                map.remove(lChar);
            }
            if (map.size() == k) {
                count++;
            }
            left++;
        }

        return count;
    }
}