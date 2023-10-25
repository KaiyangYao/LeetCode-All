import java.util.*;

/**
 * Sliding Window 模板题
 * 
 * 2023/07/05
 */

/**
 * O(n) time | O(26) = O(1) space
 */
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        String ans = "";
        int count = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            char rightC = s.charAt(right);
            sMap.put(rightC, sMap.getOrDefault(rightC, 0) + 1);
            if (tMap.containsKey(rightC) && sMap.get(rightC) <= tMap.get(rightC)) {
                count++;
            }

            while (left < right && (!tMap.containsKey(s.charAt(left)) || sMap.get(s.charAt(left)) > tMap.get(s.charAt(left)))) {
                char leftC = s.charAt(left);
                sMap.put(leftC, sMap.get(leftC) - 1);
                left++;
            }

            if (count == t.length()) {
                if (ans.length() == 0) {
                    ans = s.substring(left, right + 1);
                } else {
                    ans = right - left + 1 < ans.length() ? s.substring(left, right + 1) : ans;
                }
            }
        }

        return ans;
    }
}