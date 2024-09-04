/**
 * 2023/01/18
 */

/**
 * 先从1-9排列，然后遇到D再inverse
 * 
 * O(n) time | O(1) space
 */
class Solution2375 {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n + 1; i++) {
            sb.append(i + 1);
        }

        int i = 0;
        int startIndex = i;
        while (i < n) {
            while (i < n && pattern.charAt(i) == 'I') {
                i++;
            }

            int startD = i;
            while (i < n && pattern.charAt(i) == 'D') {
                i++;
            }
            int endD = i;

            sb = new StringBuilder()
                    .append(sb.substring(startIndex, startD))
                    .append(new StringBuilder(sb.substring(startD, endD + 1)).reverse())
                    .append(sb.substring(endD + 1, n + 1));
        }

        return sb.toString();
    }
}