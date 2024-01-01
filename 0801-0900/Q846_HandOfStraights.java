import java.util.*;

/**
 * Greedy
 * 2023/12/04
 */

/**
 * O(n logn) time
 * O(log n) space
 */
class Solution846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            if (map.get(hand[i]) == 0)
                continue;
            for (int j = 0; j < groupSize; j++) {
                int next = hand[i] + j;
                if (!map.containsKey(next) || map.get(next) == 0) {
                    return false;
                }
                map.put(next, map.get(next) - 1);
                next++;
            }
        }

        return true;
    }
}