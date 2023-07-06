import java.util.*;

/**
 * Greedy
 * 
 * 2023/07/04
 */

/*
 * O(n) time
 * O(26) space 
 */
class Solution763 {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int currStart = 0;
        int currEnd = map.get(s.charAt(0));
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            currEnd = Math.max(currEnd, map.get(s.charAt(i)));
            if (i == currEnd) {
                result.add(currEnd - currStart + 1);
                currStart = currEnd + 1;
            }
        }

        return result;
    }
}