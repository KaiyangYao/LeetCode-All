/**
 * Greedy
 * 
 * 2023/07/04
 */

 /**
  * O(n) time | O(1) space
  */
class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if ( (i == 0 || flowerbed[i-1] == 0) && flowerbed[i] == 0 && (i == flowerbed.length - 1 || flowerbed[i+1] == 0)) {
                n -= 1;
                flowerbed[i] = 1;
            }
        }

        return n <= 0;
    }
}