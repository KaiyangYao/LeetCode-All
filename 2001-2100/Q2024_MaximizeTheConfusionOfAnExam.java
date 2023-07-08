/**
 * 2023/07/07 US Daily
 * 
 * Same as Q1004!
 */

/**
 * O(n) time | O(1) space
 */
class Solution2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int max = 0;
        int t = 0, f = 0;
        for (int l = 0, r = 0; r < answerKey.length(); r++) {
            if (answerKey.charAt(r) == 'T') {
                t++;
            } else {
                f++;
            }
            while (t > k && f > k) {
                if (answerKey.charAt(l) == 'T') {
                    t--;
                } else {
                    f--;
                }
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}