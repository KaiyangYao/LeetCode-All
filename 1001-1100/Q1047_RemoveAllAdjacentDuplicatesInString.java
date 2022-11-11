/*
 * Use stack
 * 
 * O(n) time | O(n) space
 * 
 * Similar: 1544
 * 
 * 2022/11/10
 */
class Solution1047 {
    public String removeDuplicates(String s) {
        StringBuffer sb = new StringBuffer();
        for (char c: s.toCharArray()) {
            int len = sb.length();
            if (!sb.isEmpty() && sb.charAt(len-1) == c) {
                sb.delete(len-1, len);
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}