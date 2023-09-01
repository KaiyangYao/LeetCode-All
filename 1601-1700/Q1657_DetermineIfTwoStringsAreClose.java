import java.util.*;

/**
 * Hash Set / 字符集Array
 * 2023/08/30
 */

/**
 * O(n+m) time | O(1) space
 * 排序 O(26 log 26) time
 */
class Solution1657 {
    public boolean closeStrings(String word1, String word2) {
        int n = word1.length();
        if (word2.length() != n)
            return false;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < n; i++) {
            arr1[word1.charAt(i) - 'a']++;
            arr2[word2.charAt(i) - 'a']++;
        }

        // 如果字符种类不一样肯定不行，因为不可以引入新的字符
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] > 0 && arr2[i] == 0 || arr1[i] == 0 && arr2[i] > 0) {
                return false;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }

        return true;
    }
}