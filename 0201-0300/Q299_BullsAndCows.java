/*
 * O(n) time | O(10) = O(1) space
 * 
 * 2023/02/05
 */
class Solution299 {
    public String getHint(String secret, String guess) {
        int[] arr = new int[10];
        int A = 0;
        int B = 0;
        for (int i = 0; i < secret.length(); i++) {
            arr[secret.charAt(i) - '0']++;
        }

        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                arr[guess.charAt(i) - '0']--;
                A++;
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) != secret.charAt(i) && arr[guess.charAt(i) - '0'] > 0) {
                arr[guess.charAt(i) - '0']--;
                B++;
            }
        }
        
        return A + "A" + B + "B";
    }
}