import java.util.*;

/**
 * HashMap
 * O(n) time | O(n) space
 * 
 * 2023/10/24
 */

class Solution128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, num);
        }

        int ans = 0;
        for (int num : nums) {
            if (map.containsKey(num - 1)) {
                continue;
            }

            int right = map.get(num);
            while (map.containsKey(right + 1)) {
                right = map.get(right + 1);
            }

            map.put(num, right);
            ans = Math.max(ans, right - num + 1);
        }

        return ans;
    }
}