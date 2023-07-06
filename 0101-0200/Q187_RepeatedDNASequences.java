import java.util.*;

/**
 * Sliding Window
 * 
 * 2023/07/05
 */

/**
 * O(n) time | O(n) space
 */
class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (int i = 10; i <= s.length(); i++) {
            String curr = s.substring(i - 10, i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            if (map.get(curr) == 2) {
                result.add(curr);
            }
        }

        return result;
    }
}