import java.util.*;

/**
 * 2023/07/24 CN Daily
 */

/**
 * O(m+n) time | O(1) space
 */
class Solution771 {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (char c : jewels.toCharArray()) {
            set.add(c);
        }

        int count = 0;
        for (char c : stones.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }

        return count;
    }
}