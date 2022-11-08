/*
 * Character -> List (Same as #383, #387)
 * 
 * O(n) time, O(|L|) space, L is the number of unique chars
 * 
 * 2022/11/08
 */
class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;  // Important!
        
        int[] charList = new int[26];
        for (char c: s.toCharArray()) {
            charList[c - 'a'] += 1;
        }
        
        for (char c: t.toCharArray()) {
            charList[c - 'a'] -= 1;
            if (charList[c - 'a'] < 0) {
                return false;
            }
        }
        
        return true;
    }
}