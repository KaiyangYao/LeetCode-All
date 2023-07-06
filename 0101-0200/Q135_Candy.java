import java.util.*;

/*
 * Greedy
 * 
 * 2023/07/04
 */

 /**
  * O(n) time | O(n) space
  */
class Solution135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] num = new int[n];
        Arrays.fill(num, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) {
                num[i] = num[i-1] + 1;
            }
        }
        for (int j = n - 1; j > 0; j--) {
            if (ratings[j] < ratings[j-1] && num[j] >= num[j-1]) {
                num[j-1] = num[j] + 1;
            }
        }

        int result = 0;
        for (int x: num) {
            result += x;
        }

        return result;
    }
}