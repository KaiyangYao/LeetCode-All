/*
 * Sliding Window
 * 
 * len(s) = n, C = 26
 * O(Cn) = O(n) time
 * O(c) = O(1) space
 * 
 * 2023/02/04
 * 
 * Similar Questions:
 * #1004, #1208, #1493
 */
class Solution424 {
    public int characterReplacement(String s, int k) {
        int[] counter = new int[26];
        int res = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            counter[s.charAt(right) - 'A']++;
            while (!check(counter, k)) {
                counter[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    private boolean check(int[] counter, int k) {
        int maxFreq = 0;
        int sum = 0;
        for (int i: counter) {
            maxFreq = Math.max(maxFreq, i);
            sum += i;
        }
        return sum - maxFreq <= k;
    }
}