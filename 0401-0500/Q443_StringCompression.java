/**
 * 2023/08/30
 */

/**
 * O(n) time | O(1) space
 */
class Solution443 {
    public int compress(char[] chars) {
        int n = chars.length;
        int index = 0;
        int left = 0;
        int right = left + 1;
        while (left < n) {
            while (right < n && chars[right] == chars[left]) {
                right++;
            }
            String str = right - left == 1 ? "" : String.valueOf(right - left);
            chars[index++] = chars[left];
            char[] strChars = str.toCharArray();
            for (int i = 0; i < strChars.length; i++) {
                chars[index++] = strChars[i];
            }

            left = right;
        }

        return index;
    }
}