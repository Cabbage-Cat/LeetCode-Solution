/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) { return new int[0][0]; }
        int[][] res = new int[n][n];
        int i = 0, j = 0;
        int cnt = 0;
        while (cnt < n * n) {
            while (isValid(i, j, n) && res[i][j] == 0) {
                res[i][j] = ++cnt;
                j++;
            }
            j--; i++;
            while (isValid(i, j, n) && res[i][j] == 0) {
                res[i][j] = ++cnt;
                i++;
            }
            i--;j--;
            while (isValid(i, j, n) && res[i][j] == 0) {
                res[i][j] = ++cnt;
                j--;
            }
            j++; i--;
            while (isValid(i, j, n) && res[i][j] == 0) {
                res[i][j] = ++cnt;
                i--;
            }
            i++; j++;
        }
        return res;
    }
    private boolean isValid(int i, int j, int n) {
        return i > -1 && i < n && j > -1 && j < n;
    }
}
// @lc code=end

