import java.util.*;

/**
 * 找中点
 * 2024/01/08 CN Daily
 */

/**
 * O(n^2) time | O(n) space
 */
class Solution447 {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int[] p1 : points) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] p2 : points) {
                int d2 = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
                int cnt = map.getOrDefault(d2, 0);
                ans += cnt * 2;
                map.put(d2, cnt + 1);
            }
        }

        return ans;
    }
}