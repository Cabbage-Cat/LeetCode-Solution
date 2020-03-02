/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) { return; }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    for (int row = 0; row < matrix.length; row++) {
                        if (matrix[row][j] != 0) { matrix[row][j] = -1273; }
                    }
                    for (int col = 0; col < matrix[0].length; col++) {
                        if (matrix[i][col] != 0) { matrix[i][col] = -1273; }
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == -1273) { matrix[i][j] = 0; }
            }
        }
    }
}
// @lc code=end

