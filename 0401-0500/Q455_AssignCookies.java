import java.util.*;
/**
 * Greedy
 * 
 * 2023/07/04
 */

 /**
  * O(mlogm + nlogn) time | O(logm + logn) space
  */
class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int p1 = 0, p2 = 0;
        int count = 0;
        while (p1 < g.length && p2 < s.length) {
            if (s[p2] >= g[p1]) {
                count++;
                p1++;
                p2++;
            } else {
                p2++;
            }
        }
        return count;
    }
}