import java.util.*;

/**
 * 2023/09/11
 */

/**
 * O(n) time | O(m+n) space
 */
class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        Set<Integer> set = new HashSet<>();
        for (int n : nums1) {
            set.add(n);
        }

        int index = 0;
        for (int x : nums2) {
            if (set.contains(x)) {
                result[index++] = x;
                set.remove(x);
            }
        }

        return Arrays.copyOfRange(result, 0, index);
    }
}