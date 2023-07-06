import java.util.*;

/**
 * Sliding Window 模板题
 * 
 * 2023/07/05
 */

/**
 * O(n) time | O(26) = O(1) space
 */
class Solution076 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        String result = "";
        for (int left = 0, right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            sMap.put(curr, sMap.getOrDefault(curr, 0) + 1);
            if (tMap.containsKey(curr) && sMap.get(curr) <= tMap.get(curr)) {
                count++;
            }
            while (left < right
                    && (!tMap.containsKey(s.charAt(left)) || sMap.get(s.charAt(left)) > tMap.get(s.charAt(left)))) {
                int n = sMap.get(s.charAt(left));
                sMap.put(s.charAt(left), n - 1);
                left++;
            }

            if (count == t.length()) {
                if (result == "") {
                    result = s.substring(left, right + 1);
                } else {
                    result = right - left + 1 < result.length() ? s.substring(left, right + 1) : result;
                }
            }
        }

        return result;
    }
}