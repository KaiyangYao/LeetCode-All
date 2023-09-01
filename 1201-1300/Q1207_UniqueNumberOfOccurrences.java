import java.util.*;

/**
 * Hash Map/Set
 * 2023/08/30
 */

/**
 * O(n) time | O(n) space
 */
class Solution1207 {
    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for (int c : map.keySet()) {
            if (set.contains(map.get(c)))
                return false;
            set.add(map.get(c));
        }

        return true;
    }
}