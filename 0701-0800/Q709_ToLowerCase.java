/**
 * 2023/07/06
 */

/**
 * O(n) time | O(1) space
 */
class Solution709 {
    /**
     * A - Z: 65 - 90
     * a - z: 97 - 122
     * 65: 01000001
     * 97: 01100001
     * 32: 00100000
     */
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch >= 65 && ch <= 90) {
                ch |= 32;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}