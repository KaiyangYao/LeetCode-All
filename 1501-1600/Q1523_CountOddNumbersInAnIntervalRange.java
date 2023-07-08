/**
 * 2023/07/07
 */

/** 
3, 7 -> 3
3, 8 -> 3
4, 7 -> 2
4, 8 -> 2
*/

/**
 * O(1) time | O(1) space
 */
class Solution1523 {
    public int countOdds(int low, int high) {
        return (high + 1) / 2 - low / 2;
    }
}
