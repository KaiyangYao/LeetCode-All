/**
 * Sliding Window
 * 
 * 2023/08/30
 */

/**
 * O(n) time | O(1) space
 */
class Solution1456 {
    public int maxVowels(String s, int k) {
        int max = 0;
        String vowels = "aeiou";
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.indexOf(s.charAt(i)) >= 0) {
                count++;
            }
        }
        max = count;
        for (int i = k; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i - k)) >= 0) {
                count--;
            }
            if (vowels.indexOf(s.charAt(i)) >= 0) {
                count++;
            }
            max = Math.max(max, count);
        }

        return max;
    }
}