/*
 * Two Pointer
 * O(n) time | O(n) space
 * 
 * 2022/11/04
 */
class Solution345 {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        int start = 0;
        int end = s.length()-1;
        char[] array = s.toCharArray();
        
        while (start < end) {
            while (start < s.length() && !vowels.contains(String.valueOf(array[start]))) {
                start++;
            }
                   
            while (end >= 0 && !vowels.contains(String.valueOf(array[end]))) {
                end--;
            }
            
            if (start < end) {
                char temp = array[start];
                array[start++] = array[end];
                array[end--] = temp;
            }
            
        }
                   
        return new String(array);
    }
}

