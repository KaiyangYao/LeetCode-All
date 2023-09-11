import java.util.*;

/**
 * Binary Search
 * 2023/09/08
 */

/**
 * O(n log n) time | O(log n) space
 */
class Solutio2300 {
    int[] p;
    long s;

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        p = potions;
        s = success;
        Arrays.sort(p);
        int n = spells.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = getNum(spells[i]);
        }
        return result;
    }

    private int getNum(int i) {
        int count = 0;
        int left = 0, right = p.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; 
            long result = (long) p[mid] * i;
            if (result < s) {
                left = mid + 1;
            } else {
                count += (right - mid + 1);
                right = mid - 1;
            }
        }
        return count;
    }
}