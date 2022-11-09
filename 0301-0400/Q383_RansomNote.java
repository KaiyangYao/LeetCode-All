/*
 * Character -> List (Same as #242, 387)
 * 
 * O(n) time, O(|L|) space, L is the number of unique chars
 * 
 * 2022/11/08
 */
class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int m = ransomNote.length();
        int n = magazine.length();
        int[] counter = new int[26];
        
        for (int i = 0; i < n; i++) {
            counter[magazine.charAt(i) - 'a'] += 1;
        }
        
        for (int j = 0; j < m; j++) {
            counter[ransomNote.charAt(j) - 'a'] -= 1;
            if (counter[ransomNote.charAt(j) - 'a'] < 0) {
                return false;
            }
        }
        
        return true;
    }
}