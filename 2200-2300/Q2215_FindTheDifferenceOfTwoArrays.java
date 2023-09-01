import java.util.*;

/**
 * Hash Map/Set
 * 2023/08/30
 */

/**
 * O(m+n) time | O(m+n) space
 */
class Solution2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for (int n : nums1) {
            s1.add(n);
        }
        for (int n : nums2) {
            s2.add(n);
        }

        for (int n : nums1) {
            s2.remove(n);
        }
        for (int n : nums2) {
            s1.remove(n);
        }

        return List.of(List.copyOf(s1), List.copyOf(s2));
    }
}