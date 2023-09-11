import java.util.*;

/**
 * Prefix Sum + HashMap
 * 2023/09/04
 */

/**
 * O(n) time | O(n) space
 * Similar: Q974
 */
class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // <quotient, index>
        map.put(0, -1);
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int quotient = (preSum % k + k) % k; // Handle with negative number
            if (map.containsKey(quotient)) {
                if (i - map.get(quotient) >= 2) {
                    return true;
                }
            } else {
                map.put(quotient, i);
            }
        }
        return false;
    }
}