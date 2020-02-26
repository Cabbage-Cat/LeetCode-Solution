/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) { return res; }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int total = rows * cols;
        int i = 0, j = 0, cnt = 0;
        boolean[][] vis = new boolean[rows][cols];
        while (cnt < total) {
            while (isValid(i, j, rows, cols) && !vis[i][j]) {
                vis[i][j] = true;
                res.add(matrix[i][j]);
                j++;
                cnt++;
            }
            j--; i++;
            while (isValid(i, j, rows, cols) && !vis[i][j]) {
                vis[i][j] = true;
                res.add(matrix[i][j]);
                i++;
                cnt++;
            }
            i--; j--;
            while (isValid(i, j, rows, cols) && !vis[i][j]) {
                vis[i][j] = true;
                res.add(matrix[i][j]);
                j--;
                cnt++;
            }
            j++; i--;
            while (isValid(i, j, rows, cols) && !vis[i][j]) {
                vis[i][j] = true;
                res.add(matrix[i][j]);
                i--;
                cnt++;
            }
            i++; j++;
        }
        return res;
    }
    public boolean isValid(int x, int y, int r, int c) {
        return x > -1 && x < r && y > -1 && y < c;
    }
}
// @lc code=end

