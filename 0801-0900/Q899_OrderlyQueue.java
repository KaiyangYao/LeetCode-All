import java.util.*;

/*
 * O(n^2) time | O(n) space
 * 
 * 2022/11/06
 */
class Solution899 {
    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
        
        String min = s;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char c = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(c);
            if (sb.toString().compareTo(min) < 0) {
                min = sb.toString();
            }
        }
        
        return min;
    }
}