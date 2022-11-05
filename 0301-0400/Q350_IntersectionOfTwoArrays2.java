import java.util.*;

/*
 * Create the hashtable for the smaller sized list
 * 
 * o(m+n) time | O(min(m,n)) space
 * 
 * 2022/11/05
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        
        Map<Integer, Integer> counterMap = new HashMap<>();
        for (int num: nums1) {
            counterMap.put(num, counterMap.getOrDefault(num, 0) + 1);
        }
        
        int[] result = new int[nums1.length];
        int endIndex = 0;
        
        for (int num: nums2) {
            if (!counterMap.containsKey(num)) continue;
            
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