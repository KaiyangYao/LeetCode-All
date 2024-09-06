/* 
 * 20240904
 * 两个不同位置定长滑动窗口
 * 
 * O(n) time | O(n) space
 * 
*/
class Solution1652 {
  public int[] decrypt(int[] code, int k) {
    int n = code.length;
    int r = k > 0 ? k + 1 : n;
    int sum = 0;
    k = Math.abs(k);
    int[] ans = new int[n];

    for (int i = r - k; i < r; i++) {
      sum += code[i];
    }

    for (int i = 0; i < n; i++) {
      ans[i] = sum;
      sum = sum + code[r % n] - code[(r - k) % n];
      r++;
    }

    return ans;
  }
}