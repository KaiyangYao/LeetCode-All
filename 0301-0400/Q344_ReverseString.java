/*
 * Two Pointer
 * O(n) time | O(n) space
 * 
 * 2022/11/04
 */
class Solution344 {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        
        
        while (start < end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
}