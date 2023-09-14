import java.util.*;

/**
 * Solution 1: Sort + Two Pointer
 * 
 * O(m log m + n log n) time | O(log m + log n) space
 */
class Solution350_01 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1 = nums1.length, l2 = nums2.length;
        int p1 = 0, p2 = 0, index = 0;
        int[] result = new int[Math.min(l1, l2)];
        while (p1 < l1 && p2 < l2) {
            if (nums1[p1] == nums2[p2]) {
                result[index++] = nums1[p1];
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }
}

/*
 * Create the hashtable for the smaller sized list
 * 
 * o(m+n) time | O(min(m,n)) space
 * 
 * 2022/11/05
 */
class Solution350_02 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> counterMap = new HashMap<>();
        for (int num : nums1) {
            counterMap.put(num, counterMap.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[nums1.length];
        int endIndex = 0;

        for (int num : nums2) {
            if (!counterMap.containsKey(num))
                continue;

            int count = counterMap.get(num);
            if (count > 0) {
                result[endIndex++] = num;
                count--;
                if (count > 0) {
                    counterMap.put(num, count);
                } else {
                    counterMap.remove(num);
                }
            }
        }

        return Arrays.copyOfRange(result, 0, endIndex);
    }
}