import java.util.*;

/**
 * DP (= Q53)
 * 
 * 2023/07/20
 */

/**
 * O(n + m) time | O(m) space
 * m = len(chars)
 */
class Solution2606 {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < vals.length; i++) {
            map.put(chars.charAt(i), vals[i]);
        }
        int currMax = map.containsKey(s.charAt(0)) ? map.get(s.charAt(0)) : s.charAt(0) - 'a' + 1;
        int globalMax = currMax;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            int currCost = map.containsKey(c) ? map.get(c) : c - 'a' + 1;
            currMax = Math.max(currMax + currCost, currCost);
            globalMax = Math.max(currMax, globalMax);
        }

        return Math.max(globalMax, 0);
    }
}