/**
 * 2023/11/02
 */

// expand around center
class Solution005 {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        String result = "";
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int len1 = expandAroundCenter(arr, i, i);
            int len2 = expandAroundCenter(arr, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                int start = i - (len - 1) / 2;
                int end = i + len / 2;
                result = s.substring(start, end + 1);
            }
        }
        return result;
    }

    private int expandAroundCenter(char[] arr, int left, int right) {
        while (left >= 0 && right < arr.length && arr[left] == arr[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}