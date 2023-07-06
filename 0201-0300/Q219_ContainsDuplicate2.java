import java.util.*;

/**
 * 2023/07/05
 */

/**
 * O(n) time | O(n) space
 */
class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (map.containsKey(curr) && i - map.get(curr) <= k) {
                return true;
            }
            map.put(curr, i);
        }
        return false;
    }
}