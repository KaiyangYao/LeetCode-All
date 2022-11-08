/*
 * Two Loops. HashTable or List (Same as #242, #383)
 * 
 * O(n) time, O(|L|) space, L is the number of unique chars
 * .charAt for String/StringBuilder/StringBuffer is O(1)!
 *  public char charAt(int index) {
        if ((index < 0) || (index >= value.length)) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return value[index];
    } 

    .deleteCharAt is O(n)!
 * 
 * 2022/11/08
 */
class Solution387 {
    public int firstUniqChar(String s) {
        int[] counter = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            counter[index] += 1;
        }
        
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (counter[index] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}

