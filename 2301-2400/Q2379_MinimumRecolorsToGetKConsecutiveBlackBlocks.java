/* 
 * 20240904
 * 定长滑动窗口
 * 
 * O(n) time | O(1) space
 * 
*/
class Solution2379 {
  public int minimumRecolors(String blocks, int k) {
    int whiteCnt = 0;
    int minCnt;

    for (int i = 0; i < k; i++) {
      if (blocks.charAt(i) == 'W') {
        whiteCnt += 1;
      }
    }

    minCnt = whiteCnt;

    for (int i = k; i < blocks.length(); i++) {
      if (blocks.charAt(i) == 'W') {
        whiteCnt += 1;
      }
      if (blocks.charAt(i - k) == 'W') {
        whiteCnt -= 1;
      }
      minCnt = Math.min(minCnt, whiteCnt);
    }

    return minCnt;
  }
}