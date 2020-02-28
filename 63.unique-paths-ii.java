/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 ||
                obstacleGrid[0] == null || obstacleGrid[0].length == 0) { return 0; }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if (obstacleGrid[m - 1][n - 1] == 0) { dp[m-1][n-1] = 1; }
        for (int i = m - 2; i > -1; i--) {
            if (obstacleGrid[i][n-1] != 1) { dp[i][n-1] += dp[i+1][n-1]; }
        }
        for (int i = n - 2; i > -1; i--) {
            if (obstacleGrid[m-1][i] != 1) { dp[m-1][i] += dp[m-1][i+1];}
        }
        for (int i = m - 2; i > -1; i--) {
            for (int j = n - 2; j > -1; j--) {
                if (obstacleGrid[i][j] != 1) { dp[i][j] = dp[i+1][j] + dp[i][j+1]; }
            }
        }
        return dp[0][0];
    }
}
// @lc code=end

