/*
 * Sliding Window
 * 
 * len(s) = n
 * O(n) time
 * O(n) space  (cost array)
 * 
 * 2023/02/04
 * 
 * 需要先弄出一个cost array 再 sliding window
 */
class Solution1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] cost = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int result = 0;
        int currCost = 0;
        for (int left = 0, right = 0; right < cost.length; right++) {
            currCost += cost[right];
            while (currCost > maxCost) {
                currCost -= cost[left];
                left++;
            }
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}