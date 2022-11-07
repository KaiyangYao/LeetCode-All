/*
 * O(L) time | O(L) space
 * 
 * L = log_10(num) = # digits of num.
 * 
 * 2022/11/07
 */
class Solution1323 {
    public int maximum69Number (int num) {
        String numStr = String.valueOf(num);
        StringBuilder sb = new StringBuilder(numStr);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '6') {
                sb.deleteCharAt(i);
                sb.insert(i, '9');
                // OR: sb.setCharAt(i, '9');
                break;
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
}