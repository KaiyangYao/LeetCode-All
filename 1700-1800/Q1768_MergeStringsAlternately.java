/**
 * O(m+n) time
 * O(m+n) space
 * 
 * Similar: #88
 * 
 * 2023/06/27
 */
class Solution1768 {
    public String mergeAlternately(String word1, String word2) {
        int p1 = 0;
        int p2 = 0;
        StringBuilder sb = new StringBuilder();
        while (p1 < word1.length() && p2 < word2.length()) {
            sb.append(word1.charAt(p1++));
            sb.append(word2.charAt(p2++));
        }

        if (p1 < word1.length()) {
            sb.append(word1.substring(p1));
        }

        if (p2 < word2.length()) {
            sb.append(word2.substring(p2));
        }

        return sb.toString();
    }
}