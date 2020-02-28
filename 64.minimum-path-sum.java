/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0
                || grid[0] == null || grid[0].length == 0) { return 0; }
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) { continue; }
                int minSum;
                if (i == 0) { minSum = grid[i][j-1]; }
                else if (j == 0) { minSum = grid[i-1][j]; }
                else { minSum = Math.min(grid[i][j-1], grid[i-1][j]); }
                grid[i][j] += minSum;
            }
        }
        return grid[m-1][n-1];
    }
}
// @lc code=end

