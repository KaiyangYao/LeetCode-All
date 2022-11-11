/*
 * Using Stack
 * 
 * O(n) time | O(n) space
 * 
 * Similar: 1047
 * 
 * 2022/11/08
 */
class Solution1544 {
    public String makeGood(String s) {
        int n = s.length();
        if (n < 2) return s;
        
        char[] charList = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        
        for (char ch : charList) {
            int len = sb.length();
            if (!sb.isEmpty() && Math.abs(sb.charAt(len - 1) - ch) == 32) {
                sb.delete(len - 1, len);
            } else {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}