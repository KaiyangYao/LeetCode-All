import java.util.*;

/**
 * Sliding Window 固定长度
 * 2023/10/24
 */

/**
 * O(26n) = O(n) time
 * O(26) = O(1) space
 */
class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (char c : s1.toCharArray()) {
            arr1[c - 'a']++;
        }

        int i;
        for (i = 0; i < s1.length(); i++) {
            arr2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(arr1, arr2)) {
            return true;
        }
        int left = 0;
        for (int right = i; right < s2.length(); right++) {
            arr2[s2.charAt(right) - 'a']++;
            arr2[s2.charAt(left++) - 'a']--;
            if (Arrays.equals(arr1, arr2)) {
                return true;
            }
        }

        return false;
    }
}